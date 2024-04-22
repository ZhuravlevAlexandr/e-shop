package ru.aston.intensive.cartservice.service;

import org.springframework.stereotype.Service;
import ru.aston.intensive.cartservice.dto.CartResp;
import ru.aston.intensive.cartservice.dto.ProductResp;

@Service
public interface CartService {
    CartResp getCartById(Integer id);

    void addProductToCart(Integer userId, ProductResp productResp);
}
