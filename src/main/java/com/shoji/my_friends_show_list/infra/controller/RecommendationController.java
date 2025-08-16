package com.shoji.my_friends_show_list.infra.controller;

import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.RecommendationRequestCreation;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.RecommendationResponseCreation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recommendation")
public class RecommendationController {

    @PostMapping("/create-list")
    public ResponseEntity<RecommendationResponseCreation> createList (
            @RequestBody RecommendationRequestCreation request
    ) {
        return null;
    }


}
