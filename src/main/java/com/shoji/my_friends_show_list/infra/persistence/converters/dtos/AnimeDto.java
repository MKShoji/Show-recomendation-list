package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import lombok.Builder;

@Builder
public record AnimeDto(
        Integer malId,
        String title,
        String synopsis
) {
}
