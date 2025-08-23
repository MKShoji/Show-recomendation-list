package com.shoji.my_friends_show_list.application.gateways;

import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.domain.models.mediaItem.MediaItem;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;

import java.util.List;

public interface RecommendationListGateway {
    RecommendationList createList(RecommendationList recommendationList);
    RecommendationList addMediaToRecommendationList(Long listId, List<MediaItem> medias);
    List<RecommendationList> getListByUserId(Long id);
}
