package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import java.time.LocalDate;

public record UserResponse(
        Long id,
        String username,
        String alias,
        String email,
        String phone,
        String profileUrl,
        LocalDate createdDate
) {
}
