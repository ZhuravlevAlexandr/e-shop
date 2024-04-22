package ru.aston.intensive.orderservice.mapper;

import org.mapstruct.Mapper;
import ru.aston.intensive.orderservice.dto.OrderResp;
import ru.aston.intensive.orderservice.model.entity.Order;

@Mapper
public interface OrderMapper {
    Order toOrder(OrderResp orderResp);

    OrderResp toOrderResp(Order order);
}
