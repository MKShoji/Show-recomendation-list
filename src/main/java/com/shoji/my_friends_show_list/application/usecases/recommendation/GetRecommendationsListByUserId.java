package com.shoji.my_friends_show_list.application.usecases.recommendation;

import com.shoji.my_friends_show_list.application.gateways.RecommendationListGateway;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRecommendationsListByUserId {

    private final RecommendationListGateway recommendationListGateway;

    public GetRecommendationsListByUserId(RecommendationListGateway recommendationListGateway) {
        this.recommendationListGateway = recommendationListGateway;
    }

    public List<RecommendationList> execute(Long userId) {
        return this.recommendationListGateway.getListByUserId(userId);

    }
}
