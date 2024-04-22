package ru.aston.intensive.orderservice.service.impl;

import com.astonhomework.orderservice.dto.OrderDTO;
import com.astonhomework.orderservice.mapper.OrderMapper;
import com.astonhomework.orderservice.models.Order;
import com.astonhomework.orderservice.repositories.OrderRepository;
import com.astonhomework.orderservice.response.ListDtoResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.astonhomework.orderservice.mapper.OrderMapper.dtoToEntity;
import static com.astonhomework.orderservice.mapper.OrderMapper.entityListToDtoList;
import static com.astonhomework.orderservice.mapper.OrderMapper.entityToDTO;

@Service
@Transactional
public class OrderService {


    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public ListDtoResponse getOrdersByClientId(int clientId) {
        List<Order> orders = orderRepository.findByClientId(clientId);
        return new ListDtoResponse(entityListToDtoList(orders));
    }

    public OrderDTO showOrder(int id) {
        Optional<Order> maybeOrder = orderRepository.findById(id);
        Order order;
        if (maybeOrder.isPresent()) {
            order = maybeOrder.get();
        } else {
            throw new RuntimeException("Data not found");
        }
        return entityToDTO(order);
    }

    public void saveOrder(OrderDTO dto) {
        orderRepository.save(dtoToEntity(dto));
    }
}

