package com.shoji.my_friends_show_list.application.usecases.recommendation;

import com.shoji.my_friends_show_list.application.gateways.RecommendationListGateway;

public class AddMidiaRecommendation {

    private final RecommendationListGateway recommendationListGateway;

    public AddMidiaRecommendation(RecommendationListGateway recommendationListGateway) {
        this.recommendationListGateway = recommendationListGateway;
    }

    public void execute() {
        System.out.println("Adicionado Mídia com id");
    }
}
