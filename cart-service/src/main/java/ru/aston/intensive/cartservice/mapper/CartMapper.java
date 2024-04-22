package ru.aston.intensive.cartservice.mapper;

import org.mapstruct.Mapper;
import ru.aston.intensive.cartservice.dto.CartResp;
import ru.aston.intensive.cartservice.model.entity.Cart;

@Mapper
public interface CartMapper {
    Cart toCart(CartResp cartResp);

    CartResp toCartResp(Cart cart);
}
