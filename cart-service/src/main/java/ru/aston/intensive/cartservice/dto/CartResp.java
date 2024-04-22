package ru.aston.intensive.cartservice.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CartResp(Integer userId, List<ProductResp> products, Integer amount) {
}
