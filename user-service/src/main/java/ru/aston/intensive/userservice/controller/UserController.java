package ru.aston.intensive.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.intensive.userservice.dto.UserResp;
import ru.aston.intensive.userservice.dto.UserWithCart;
import ru.aston.intensive.userservice.dto.UserWithOrders;
import ru.aston.intensive.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResp> getUser(@PathVariable("id") Integer id) {
        UserResp userResp = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResp);
    }

    @GetMapping("/{id}/carts")
    public ResponseEntity<UserWithCart> getUserCart(@PathVariable("id") Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserWithCartById(id));
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<UserWithOrders> getUserWithOrders(@PathVariable("id") Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserWithOrdersById(id));
    }

    @GetMapping()
    public ResponseEntity<List<UserResp>> getAllUsers() {
        List<UserResp> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/registration")
    public ResponseEntity<String> createUser(@RequestBody UserResp userResp) {

        if (userService.create(userResp)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Пользователь сохранен!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Пользователь с таким мылом уже существует");
    }
}
