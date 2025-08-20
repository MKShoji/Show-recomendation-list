package com.shoji.my_friends_show_list.domain.models.mediaItem;

import com.shoji.my_friends_show_list.domain.enums.MediaSource;

public record MediaItem(
    Long id,
    String externalId,
    MediaSource mediaSource
) {
}
