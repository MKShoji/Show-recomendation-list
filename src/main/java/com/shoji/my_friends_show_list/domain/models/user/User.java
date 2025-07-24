package com.shoji.my_friends_show_list.domain.models.user;

import java.util.Date;

public record User(
        Long id,
        String username,
        String alias,
        String email
) {
}
