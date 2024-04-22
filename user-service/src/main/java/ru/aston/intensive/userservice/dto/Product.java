package ru.aston.intensive.userservice.dto;

import lombok.Builder;

@Builder
public record Product(String title, Integer price) {
}
