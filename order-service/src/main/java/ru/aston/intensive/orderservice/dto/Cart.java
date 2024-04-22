package ru.aston.intensive.orderservice.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record Cart(Integer userId, List<ProductResp> products, Integer amount) {
}
