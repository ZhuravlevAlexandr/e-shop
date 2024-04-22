package ru.aston.intensive.cartservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.intensive.cartservice.model.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

    @Override
    boolean existsById(Integer userId);
}
