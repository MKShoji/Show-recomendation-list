package com.shoji.my_friends_show_list.application.gateways;

import com.shoji.my_friends_show_list.domain.models.user.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
}
