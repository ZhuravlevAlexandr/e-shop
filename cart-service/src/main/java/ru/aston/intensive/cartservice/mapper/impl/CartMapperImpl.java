package ru.aston.intensive.cartservice.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aston.intensive.cartservice.dto.CartResp;
import ru.aston.intensive.cartservice.mapper.CartMapper;
import ru.aston.intensive.cartservice.mapper.ProductMapper;
import ru.aston.intensive.cartservice.model.entity.Cart;

@Component
public class CartMapperImpl implements CartMapper {

    private final ProductMapper productMapper;

    @Autowired
    public CartMapperImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Cart toCart(CartResp cartResp) {
        return Cart.builder()
                .userId(cartResp.userId())
                .products(cartResp.products().stream().map(productMapper::toProduct).toList())
                .amount(cartResp.amount())
                .build();
    }

    @Override
    public CartResp toCartResp(Cart cart) {
        return CartResp.builder()
                .userId(cart.getUserId())
                .products(cart.getProducts().stream().map(productMapper::toProductResp).toList())
                .amount(cart.getAmount())
                .build();
    }
}
