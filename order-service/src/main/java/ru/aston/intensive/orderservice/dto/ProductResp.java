package ru.aston.intensive.orderservice.dto;

import lombok.Builder;

@Builder
public record ProductResp(String title, Integer price) {
}
