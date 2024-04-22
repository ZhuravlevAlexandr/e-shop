package ru.aston.intensive.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.intensive.cartservice.dto.CartResp;
import ru.aston.intensive.cartservice.dto.ProductResp;
import ru.aston.intensive.cartservice.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResp> getUserCart(@PathVariable Integer id) {
        CartResp cartResp = cartService.getCartById(id);

        return ResponseEntity.status(HttpStatus.OK).body(cartResp);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> addProduct(@PathVariable Integer id, @RequestBody ProductResp productResp) {
        cartService.addProductToCart(id, productResp);

        return ResponseEntity.status(HttpStatus.CREATED).body("Продукт добавлен в корзину");
    }
}
