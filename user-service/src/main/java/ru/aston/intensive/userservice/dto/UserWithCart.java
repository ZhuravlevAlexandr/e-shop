package ru.aston.intensive.userservice.dto;

import lombok.Builder;

@Builder
public record UserWithCart(UserResp user, Cart cart) {
}
