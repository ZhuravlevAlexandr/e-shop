package ru.aston.intensive.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.intensive.orderservice.dto.Cart;
import ru.aston.intensive.orderservice.dto.OrderResp;
import ru.aston.intensive.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResp> getOrder(@PathVariable Integer id) {
        OrderResp orderResp = orderService.getOrderById(id);

        return ResponseEntity.status(HttpStatus.OK).body(orderResp);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<List<OrderResp>> getAllOrdersUser(@PathVariable Integer id){
        List<OrderResp> orders = orderService.getOrdersByUserId(id);

        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping()
    ResponseEntity<List<OrderResp>> getAllOrders(){
        List<OrderResp> orders = orderService.getAllOrders();

        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody Cart cart){
        orderService.saveOrder(cart);

        return ResponseEntity.status(HttpStatus.CREATED).body("Заказ сформирован");
    }
}
