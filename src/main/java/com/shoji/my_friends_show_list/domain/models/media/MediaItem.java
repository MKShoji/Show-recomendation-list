package com.shoji.my_friends_show_list.domain.models.media;

public record MediaItem(
        Long userId,
        String mediaExternalId,
        String notes,
        Double userScore
) {
}
