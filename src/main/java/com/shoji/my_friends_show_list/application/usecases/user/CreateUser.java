package com.shoji.my_friends_show_list.application.usecases.user;

import com.shoji.my_friends_show_list.application.gateways.UserGateway;
import com.shoji.my_friends_show_list.domain.models.user.User;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.UserRequestCreation;

import java.time.LocalDate;

public class CreateUser {

    private final UserGateway userGateway;

    public CreateUser(UserGateway userGateway) { this.userGateway = userGateway; }

    public User execute(UserRequestCreation creationDto) {

        User user = new User(
                null,
                creationDto.username(),
                creationDto.alias(),
                creationDto.email(),
                creationDto.password(),
                LocalDate.now(),
                creationDto.phone(),
                creationDto.profileUrl(),
                null
        );

        return userGateway.createUser(user);
    }

}
