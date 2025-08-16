package com.shoji.my_friends_show_list.domain.models.recommendation;

import com.shoji.my_friends_show_list.domain.enums.ListVisibility;
import com.shoji.my_friends_show_list.domain.models.mediaItem.MediaItem;

import java.time.LocalDateTime;
import java.util.List;

public record RecommendationList(
        Long id,
        Long ownerId,
        String name,
        List<MediaItem> medias,
        ListVisibility visibility,
        LocalDateTime createdAt
) {
}
