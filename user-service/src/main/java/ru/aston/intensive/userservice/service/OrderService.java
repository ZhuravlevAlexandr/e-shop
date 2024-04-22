package ru.aston.intensive.userservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.aston.intensive.userservice.dto.Order;

import java.util.List;

@Service
@FeignClient(name = "order-service")
public interface OrderService {

    @GetMapping("/orders/users/{id}")
    ResponseEntity<List<Order>> getAllOrdersUser(@PathVariable Integer id);
}
