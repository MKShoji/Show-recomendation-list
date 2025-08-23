package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;

import java.util.List;

public record RecommendationResponseListByUser(
    List<RecommendationList> data
) {

}
