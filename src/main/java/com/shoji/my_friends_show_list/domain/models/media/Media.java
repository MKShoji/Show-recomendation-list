package com.shoji.my_friends_show_list.domain.models.media;

import com.shoji.my_friends_show_list.domain.enums.MediaType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record Media(
        String externalId,
        String title,
        String description,
        List<String> genre,
        LocalDate releaseDate,
        MediaType mediaType,
        Double score,
        String bannerUrl,
        String source
) {
}
