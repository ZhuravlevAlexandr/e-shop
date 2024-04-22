package ru.aston.intensive.userservice.dto;

import lombok.Builder;

@Builder
public record UserResp(Integer id, String firstName, String lastName, String email) {

}
