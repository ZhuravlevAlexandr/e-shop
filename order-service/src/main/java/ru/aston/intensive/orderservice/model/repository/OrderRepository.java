package ru.aston.intensive.orderservice.model.repository;

import com.astonhomework.orderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {

    Optional <Order> findById(int id);

    List<Order> findByClientId(int clientId);


}