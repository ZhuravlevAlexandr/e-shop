package ru.aston.intensive.userservice.mapper;

import org.mapstruct.Mapper;
import ru.aston.intensive.userservice.dto.UserResp;
import ru.aston.intensive.userservice.model.entitie.User;


@Mapper
public interface UserMapper {

    User toUser(UserResp userResp);

    UserResp toUserResp(User user);
}
