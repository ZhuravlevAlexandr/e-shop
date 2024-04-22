package ru.aston.intensive.orderservice.controller;

import com.astonhomework.orderservice.dto.OrderDTO;
import com.astonhomework.orderservice.response.ListDtoResponse;
import com.astonhomework.orderservice.response.SaveOrderResponse;
import com.astonhomework.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@ComponentScan
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<ListDtoResponse> showAllOrders(@RequestParam("clientId")int clientId) {
        return ResponseEntity.ok(orderService.getOrdersByClientId(clientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> showOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.showOrder(id));
    }

    @PostMapping("/add")
    public SaveOrderResponse add(@RequestBody OrderDTO dto) {
        orderService.saveOrder(dto);
        return new SaveOrderResponse();
    }
}
