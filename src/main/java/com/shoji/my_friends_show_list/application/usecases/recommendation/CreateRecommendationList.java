package com.shoji.my_friends_show_list.application.usecases.recommendation;

import com.shoji.my_friends_show_list.application.gateways.RecommendationListGateway;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.RecommendationRequestCreation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class CreateRecommendationList {

    private final RecommendationListGateway recommendationListGateway;

    public CreateRecommendationList(RecommendationListGateway recommendationListGateway) {
        this.recommendationListGateway = recommendationListGateway;
    }

    public RecommendationList execute(RecommendationRequestCreation recommendationDto) {

        RecommendationList recommendationList = new RecommendationList(
                null,
                recommendationDto.ownerId(),
                recommendationDto.name(),
                null,
                null,
                LocalDateTime.now()
        );

        return recommendationListGateway.createList(recommendationList);
    }
}
