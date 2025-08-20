package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import com.shoji.my_friends_show_list.domain.enums.ListVisibility;
import java.util.List;

public record RecommendationRequestCreation(
    Long ownerId,
    String name,
    List<MediaItemRequest> medias,
    ListVisibility visibility
) {
}
