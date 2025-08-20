package com.shoji.my_friends_show_list.infra.controller;

import com.shoji.my_friends_show_list.application.usecases.recommendation.CreateRecommendationList;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.RecommendationRequestCreation;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.RecommendationResponseCreation;
import com.shoji.my_friends_show_list.infra.persistence.converters.mappers.RecommendationListMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/recommendation")
public class RecommendationController {

    private final CreateRecommendationList createRecommendationList;
    private final RecommendationListMapper recommendationListMapper;

    public RecommendationController(CreateRecommendationList createRecommendationList, RecommendationListMapper recommendationListMapper) {
        this.createRecommendationList = createRecommendationList;
        this.recommendationListMapper = recommendationListMapper;
    }

    @PostMapping("/create-list")
    public ResponseEntity<RecommendationResponseCreation> createList (
            @RequestBody RecommendationRequestCreation request
    ) {
        RecommendationList recommendationList = recommendationListMapper.createRequestToDomain(request);
        RecommendationResponseCreation response = recommendationListMapper.domainToCreateResponse(
                createRecommendationList.execute(recommendationList)
        );

        URI location = URI.create("/api/recommendation/" + response.id());

        return ResponseEntity.created(location).body(response);
    }


    @PostMapping("/add-midia")
    public ResponseEntity addMidiaToList () {


        return ResponseEntity.ok().build();
    }
}
