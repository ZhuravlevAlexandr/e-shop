package ru.aston.intensive.cartservice.dto;

import lombok.Builder;

@Builder
public record ProductResp(String title, Integer price) {
}
