package ru.aston.intensive.userservice.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aston.intensive.userservice.dto.UserResp;
import ru.aston.intensive.userservice.mapper.UserMapper;
import ru.aston.intensive.userservice.model.entitie.User;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserResp userResp) {
        return User.builder()
                .id(userResp.id())
                .firstName(userResp.firstName())
                .lastName(userResp.lastName())
                .email(userResp.email())
                .build();
    }

    @Override
    public UserResp toUserResp(User user) {
        return UserResp.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
