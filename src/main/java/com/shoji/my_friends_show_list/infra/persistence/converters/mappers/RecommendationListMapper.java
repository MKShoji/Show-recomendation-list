package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.RecommendationRequestCreation;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.RecommendationResponseCreation;
import com.shoji.my_friends_show_list.infra.persistence.entities.RecommendationListEntity;

public interface RecommendationListMapper {
    RecommendationList toDomain(RecommendationListEntity entity);
    RecommendationListEntity toEntity(RecommendationList recommendationList);
    RecommendationList createRequestToDomain(RecommendationRequestCreation request);
    RecommendationResponseCreation domainToCreateResponse(RecommendationList domain);
}
