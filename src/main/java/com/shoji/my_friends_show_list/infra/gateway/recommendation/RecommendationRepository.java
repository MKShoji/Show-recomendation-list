package com.shoji.my_friends_show_list.infra.gateway.recommendation;

import com.shoji.my_friends_show_list.application.gateways.RecommendationListGateway;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import com.shoji.my_friends_show_list.infra.persistence.repository.RecommendationRepositoryJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RecommendationRepository implements RecommendationListGateway {

    private final RecommendationRepositoryJpa repositoryJpa;

    public RecommendationRepository(RecommendationRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public RecommendationList createList(RecommendationList recommendationList) {
        return null;
    }

    @Override
    public void addMediaToRecommendationList(Media media) {
        System.out.println("Adicionadar Mídia");
    }

}
