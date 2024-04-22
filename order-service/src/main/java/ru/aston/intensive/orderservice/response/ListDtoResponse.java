package ru.aston.intensive.orderservice.response;

import com.astonhomework.orderservice.dto.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record ListDtoResponse(List<OrderDTO> items) {

}
