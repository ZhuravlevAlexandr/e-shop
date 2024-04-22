package ru.aston.intensive.orderservice.service;

import org.springframework.stereotype.Service;
import ru.aston.intensive.orderservice.dto.Cart;
import ru.aston.intensive.orderservice.dto.OrderResp;

import java.util.List;

@Service
public interface OrderService {
    OrderResp getOrderById(Integer id);

    List<OrderResp> getOrdersByUserId(Integer userId);

    List<OrderResp> getAllOrders();

    void saveOrder(Cart cart);
}
