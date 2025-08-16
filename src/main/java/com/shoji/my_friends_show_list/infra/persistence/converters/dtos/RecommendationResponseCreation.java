package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import java.time.LocalDate;

public record RecommendationResponseCreation(
        Long id,
        Long ownerId,
        LocalDate creadedAt
) {
}
