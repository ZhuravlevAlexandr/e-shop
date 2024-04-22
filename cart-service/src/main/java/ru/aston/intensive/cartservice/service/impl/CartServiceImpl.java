package ru.aston.intensive.cartservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.intensive.cartservice.dto.CartResp;
import ru.aston.intensive.cartservice.dto.ProductResp;
import ru.aston.intensive.cartservice.mapper.CartMapper;
import ru.aston.intensive.cartservice.mapper.ProductMapper;
import ru.aston.intensive.cartservice.model.entity.Cart;
import ru.aston.intensive.cartservice.model.entity.Product;
import ru.aston.intensive.cartservice.model.repository.CartRepo;
import ru.aston.intensive.cartservice.model.repository.ProductRepo;
import ru.aston.intensive.cartservice.service.CartService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;
    private final ProductRepo productRepo;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;

    @Autowired
    public CartServiceImpl(CartRepo cartRepo, ProductRepo productRepo, CartMapper cartMapper, ProductMapper productMapper) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
    }

    @Override
    public CartResp getCartById(Integer id) {
        return cartMapper.toCartResp(cartRepo.getReferenceById(id));
    }

    @Override
    public void addProductToCart(Integer userId, ProductResp productResp) {

        if (cartRepo.existsById(userId)) {
            Cart cart = cartRepo.getReferenceById(userId);
            cart.getProducts().add(productMapper.toProduct(productResp));
            cart.setAmount(cart.getAmount() + productResp.price());
            cartRepo.save(cart);
        } else {
            Cart cart = Cart.builder()
                    .userId(userId)
                    .products(List.of(productMapper.toProduct(productResp)))
                    .amount(productResp.price())
                    .build();
            cartRepo.save(cart);
        }
    }
}
