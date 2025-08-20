package com.shoji.my_friends_show_list.application.usecases.recommendation;

import com.shoji.my_friends_show_list.application.gateways.RecommendationListGateway;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import org.springframework.stereotype.Service;

@Service
public class CreateRecommendationList {

    private final RecommendationListGateway recommendationListGateway;

    public CreateRecommendationList(RecommendationListGateway recommendationListGateway) {
        this.recommendationListGateway = recommendationListGateway;
    }

    public RecommendationList execute(RecommendationList recommendationList) {
        return recommendationListGateway.createList(recommendationList);
    }
}
