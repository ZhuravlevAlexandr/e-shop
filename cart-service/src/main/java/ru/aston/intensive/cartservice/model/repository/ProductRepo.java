package ru.aston.intensive.cartservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.intensive.cartservice.model.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
