package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

public record UserRequestCreation(
        String username,
        String alias,
        String email,
        String password,
        String phone,
        String profileUrl
) {}
