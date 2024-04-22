package ru.aston.intensive.orderservice.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aston.intensive.orderservice.dto.OrderResp;
import ru.aston.intensive.orderservice.mapper.OrderMapper;
import ru.aston.intensive.orderservice.mapper.ProductMapper;
import ru.aston.intensive.orderservice.model.entity.Order;

@Component
public class OrderMapperImpl implements OrderMapper {
    private final ProductMapper productMapper;

    @Autowired
    public OrderMapperImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Order toOrder(OrderResp orderResp) {
        return Order.builder()
                .id(orderResp.number())
                .userId(orderResp.userId())
                .products(orderResp.products().stream().map(productMapper::toProduct).toList())
                .amount(orderResp.amount())
                .dateOrder(orderResp.dateOrder())
                .build();
    }

    @Override
    public OrderResp toOrderResp(Order order) {
        return OrderResp.builder()
                .number(order.getId())
                .userId(order.getUserId())
                .products(order.getProducts().stream().map(productMapper::toProductResp).toList())
                .amount(order.getAmount())
                .dateOrder(order.getDateOrder())
                .build();
    }
}
