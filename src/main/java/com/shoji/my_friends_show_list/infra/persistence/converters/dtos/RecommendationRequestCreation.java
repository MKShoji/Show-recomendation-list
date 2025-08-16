package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import java.util.List;
import java.util.Set;

public record RecommendationRequestCreation(
    Long ownerId,
    String name,
    Set<String> externalIds,
    String visibility
) {
}
