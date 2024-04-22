package ru.aston.intensive.productservice.dto;

import lombok.Builder;

@Builder
public record ProductResp(String title, Integer price) {
}
