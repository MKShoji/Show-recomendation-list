package com.shoji.my_friends_show_list.application.usecases.user;

import com.shoji.my_friends_show_list.application.gateways.UserGateway;
import com.shoji.my_friends_show_list.domain.models.user.User;

import java.util.List;

public class GetAllUser {

    private final UserGateway userGateway;

    public GetAllUser(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<User> execute() {
        return userGateway.getAllUsers();
    }
}
