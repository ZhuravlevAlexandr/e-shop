package ru.aston.intensive.orderservice.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record OrderResp(Integer number, Integer userId, List<ProductResp> products, Integer amount, LocalDateTime dateOrder) {
}
