package ru.aston.intensive.userservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.aston.intensive.userservice.dto.Cart;

@Service
@FeignClient(name = "cart-service")
public interface CartService {

    @GetMapping("/carts/{id}")
    ResponseEntity<Cart> getUserCart(@PathVariable Integer id);
}
