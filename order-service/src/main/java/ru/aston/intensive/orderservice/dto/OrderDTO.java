package ru.aston.intensive.orderservice.dto;

import org.springframework.stereotype.Component;

@Component
public class OrderMapperOrderDTO {

    private Integer clientId;

    private String name;

    public OrderDTO(Integer clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }

    public OrderDTO() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
