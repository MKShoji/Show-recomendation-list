package com.shoji.my_friends_show_list.domain.models.user;

import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;

import java.time.LocalDate;
import java.util.List;

public record User (
        Long id,
        String username,
        String alias,
        String email,
        String password,
        LocalDate createdDate,
        String phone,
        String profileUrl,
        List<RecommendationList> mediaCollectionList
) { }
