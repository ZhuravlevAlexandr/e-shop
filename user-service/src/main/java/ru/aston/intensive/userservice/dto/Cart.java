package ru.aston.intensive.userservice.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record Cart(List<Product> products, Integer amount) {
}
