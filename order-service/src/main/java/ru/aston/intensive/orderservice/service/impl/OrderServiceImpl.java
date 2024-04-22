package ru.aston.intensive.orderservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.intensive.orderservice.dto.Cart;
import ru.aston.intensive.orderservice.dto.OrderResp;
import ru.aston.intensive.orderservice.mapper.OrderMapper;
import ru.aston.intensive.orderservice.mapper.ProductMapper;
import ru.aston.intensive.orderservice.model.entity.Order;
import ru.aston.intensive.orderservice.model.repository.OrderRepo;
import ru.aston.intensive.orderservice.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, OrderMapper orderMapper, ProductMapper productMapper) {
        this.orderRepo = orderRepo;
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
    }

    @Override
    public OrderResp getOrderById(Integer id) {
        return orderMapper.toOrderResp(orderRepo.getReferenceById(id));
    }

    @Override
    public List<OrderResp> getOrdersByUserId(Integer userId) {
        return orderRepo.findAllByUserId(userId).stream().map(orderMapper::toOrderResp).toList();
    }

    @Override
    public List<OrderResp> getAllOrders() {
        return orderRepo.findAll().stream().map(orderMapper::toOrderResp).toList();
    }

    @Override
    public void saveOrder(Cart cart) {
        Order order = Order.builder()
                .userId(cart.userId())
                .products(cart.products().stream().map(productMapper::toProduct).toList())
                .amount(cart.amount())
                .dateOrder(LocalDateTime.now())
                .build();
        orderRepo.save(order);
    }
}
