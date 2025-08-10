package com.shoji.my_friends_show_list.application.usecases.user;

import com.shoji.my_friends_show_list.application.gateways.UserGateway;
import com.shoji.my_friends_show_list.domain.models.user.User;

import java.util.Optional;

public class GetUserById {

    private final UserGateway userGateway;

    public GetUserById(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Optional<User> execute(Long id) {
        return userGateway.getUserById(id);
    }
}
