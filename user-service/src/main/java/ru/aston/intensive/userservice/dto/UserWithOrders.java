package ru.aston.intensive.userservice.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record UserWithOrders(UserResp user, List<Order> orders) {

}
