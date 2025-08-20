package com.shoji.my_friends_show_list.application.gateways;

import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;

import java.util.List;

public interface RecommendationListGateway {
    RecommendationList createList(RecommendationList recommendationList);
    void addMediaToRecommendationList(Media media);
    List<RecommendationList> getListById(Long id);
}
