package com.shoji.my_friends_show_list.infra.controller;

import com.shoji.my_friends_show_list.application.usecases.recommendation.AddMediaRecommendation;
import com.shoji.my_friends_show_list.application.usecases.recommendation.CreateRecommendationList;
import com.shoji.my_friends_show_list.application.usecases.recommendation.GetRecommendationsListByUserId;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.domain.models.mediaItem.MediaItem;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.*;
import com.shoji.my_friends_show_list.infra.persistence.converters.mappers.RecommendationListMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/recommendation")
public class RecommendationController {

    private final CreateRecommendationList createRecommendationList;
    private final GetRecommendationsListByUserId getRecommendationsListByUserId;
    private final RecommendationListMapper recommendationListMapper;
    private final AddMediaRecommendation addMediaRecommendation;

    public RecommendationController(CreateRecommendationList createRecommendationList, GetRecommendationsListByUserId getRecommendationsListByUserId, RecommendationListMapper recommendationListMapper, AddMediaRecommendation addMediaRecommendation) {
        this.createRecommendationList = createRecommendationList;
        this.getRecommendationsListByUserId = getRecommendationsListByUserId;
        this.recommendationListMapper = recommendationListMapper;
        this.addMediaRecommendation = addMediaRecommendation;
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


    @PostMapping("/add-midia/{listId}")
    public ResponseEntity<AddMediaResponse> addMediasToList(
            @PathVariable Long listId,
            @RequestBody AddMediasRequest request
            ) {

        List<MediaItem> medias =  request.medias().stream()
                .map(m -> new MediaItem(null, m.externalId(), m.source())).toList();

        RecommendationList updatedList = addMediaRecommendation.execute(listId, medias);

        List<MediaAdded> mediaAddedList = updatedList.medias().stream()
                .map(m -> new MediaAdded(m.externalId(), m.mediaSource())).toList();

        AddMediaResponse response = new AddMediaResponse(updatedList.id(), mediaAddedList);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/list-user/{ownerId}")
    public ResponseEntity<RecommendationResponseListByUser> getListByUser(@PathVariable Long ownerId) {
        List<RecommendationList> response = getRecommendationsListByUserId.execute(ownerId);

        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(new RecommendationResponseListByUser(response));
    }
}
