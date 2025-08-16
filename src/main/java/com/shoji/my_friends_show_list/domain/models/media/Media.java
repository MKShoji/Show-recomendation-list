package com.shoji.my_friends_show_list.domain.models.media;

import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.enums.MediaType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record Media(
        String externalId,
        String title,
        String description,
        List<String> genre,
        LocalDateTime releaseDate,
        Double score,
        String bannerUrl,
        MediaType mediaType,
        MediaSource mediaSource
) {
}
