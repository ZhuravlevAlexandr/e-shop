package ru.aston.intensive.userservice.service;

import org.springframework.stereotype.Service;
import ru.aston.intensive.userservice.dto.UserResp;
import ru.aston.intensive.userservice.dto.UserWithCart;
import ru.aston.intensive.userservice.dto.UserWithOrders;

import java.util.List;


@Service
public interface UserService {
    UserResp getUserById(Integer id);

    List<UserResp> getAllUsers();

    UserWithCart getUserWithCartById(Integer id);

    UserWithOrders getUserWithOrdersById(Integer id);

    boolean create(UserResp userResp);

}

