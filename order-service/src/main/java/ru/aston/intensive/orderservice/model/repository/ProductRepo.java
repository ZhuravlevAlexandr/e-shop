package ru.aston.intensive.orderservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.intensive.orderservice.model.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
