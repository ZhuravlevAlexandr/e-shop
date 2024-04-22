package ru.aston.intensive.productservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.intensive.productservice.model.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
