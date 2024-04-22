package ru.aston.intensive.userservice.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record Order(Integer number, List<Product> products, Integer amount, LocalDateTime dateOrder) {
}
