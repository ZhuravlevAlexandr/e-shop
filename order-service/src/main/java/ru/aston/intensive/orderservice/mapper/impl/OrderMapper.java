package ru.aston.intensive.orderservice.mapper.impl;

import com.astonhomework.orderservice.dto.OrderDTO;
import com.astonhomework.orderservice.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrderMapper {

    @Autowired
    public OrderMapper() {
    }

    public static Order dtoToEntity(OrderDTO dto) {
        return new Order(dto.getClientId(), dto.getName());
    }

    public static OrderDTO entityToDTO(Order order) {
        return new OrderDTO(order.getClientId(), order.getName());
    }

    public static List<OrderDTO> entityListToDtoList(List<Order> list) {
        List<OrderDTO> dtos = new ArrayList<>();
        for (Order entity : list) {
            dtos.add(entityToDTO(entity));
        }
        return dtos;
    }

    public static List<Order> dtoListToEntityList (List<OrderDTO> list) {
        List<Order> entities = new ArrayList<>();
        for (OrderDTO dto : list) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
