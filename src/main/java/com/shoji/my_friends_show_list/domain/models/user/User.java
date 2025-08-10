package com.shoji.my_friends_show_list.domain.models.user;

import java.time.LocalDate;

public record User (
        Long id,
        String username,
        String alias,
        String email,
        String password,
        LocalDate createdDate,
        String phone,
        String profileUrl
) { }
