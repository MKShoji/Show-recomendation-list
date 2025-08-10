package com.shoji.my_friends_show_list.domain.models.media;

import com.shoji.my_friends_show_list.domain.enums.CollectionVisibility;

import java.util.List;

public record MediaCollection(
        Long owener,
        String name,
        List<MediaItem> mediaItens,
        CollectionVisibility visibility
) {
}
