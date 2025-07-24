package com.shoji.my_friends_show_list.domain.models.media;

import com.shoji.my_friends_show_list.domain.enums.MediaType;

import java.time.LocalDate;
import java.util.Date;

public record Media(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        MediaType mediaType
) {
}
