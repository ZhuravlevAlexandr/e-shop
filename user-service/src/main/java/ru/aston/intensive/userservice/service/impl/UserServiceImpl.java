package ru.aston.intensive.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.intensive.userservice.dto.Cart;
import ru.aston.intensive.userservice.dto.Order;
import ru.aston.intensive.userservice.dto.UserResp;
import ru.aston.intensive.userservice.dto.UserWithCart;
import ru.aston.intensive.userservice.dto.UserWithOrders;
import ru.aston.intensive.userservice.mapper.UserMapper;
import ru.aston.intensive.userservice.model.repository.UserRepo;
import ru.aston.intensive.userservice.service.CartService;
import ru.aston.intensive.userservice.service.OrderService;
import ru.aston.intensive.userservice.service.UserService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final OrderService orderService;
    private final CartService cartService;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper, OrderService orderService, CartService cartService) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @Override
    public UserResp getUserById(Integer id) {
        return userMapper.toUserResp(userRepo.getReferenceById(id));
    }

    @Override
    public List<UserResp> getAllUsers() {
        return userRepo.findAll().stream().map(userMapper::toUserResp).collect(Collectors.toList());
    }

    @Override
    public UserWithCart getUserWithCartById(Integer id) {
        UserResp userResp = userMapper.toUserResp(userRepo.getReferenceById(id));

        Cart cart = cartService.getUserCart(id).getBody();

        return UserWithCart.builder().user(userResp).cart(cart).build();
    }

    @Override
    public UserWithOrders getUserWithOrdersById(Integer id) {
        UserResp userResp = userMapper.toUserResp(userRepo.getReferenceById(id));

        List<Order> orders = orderService.getAllOrdersUser(id).getBody();

        return UserWithOrders.builder().user(userResp).orders(orders).build();
    }

    @Override
    public boolean create(UserResp userResp) {
        if (userRepo.existsByEmail(userResp.email())) {
            return false;
        }
        userRepo.save(userMapper.toUser(userResp));
        return true;
    }
}
