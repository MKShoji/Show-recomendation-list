package com.shoji.my_friends_show_list.infra.gateway.recommendation;

import com.shoji.my_friends_show_list.application.gateways.RecommendationListGateway;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import com.shoji.my_friends_show_list.infra.persistence.converters.mappers.RecommendationListMapper;
import com.shoji.my_friends_show_list.infra.persistence.entities.MediaItemEntity;
import com.shoji.my_friends_show_list.infra.persistence.entities.RecommendationListEntity;
import com.shoji.my_friends_show_list.infra.persistence.repository.MediaItemJpa;
import com.shoji.my_friends_show_list.infra.persistence.repository.RecommendationRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecommendationRepository implements RecommendationListGateway {

    private final RecommendationRepositoryJpa jpaRepository;
    private final MediaItemJpa mediaItemJpa;
    private final RecommendationListMapper recommendationListMapper;

    public RecommendationRepository(
            RecommendationRepositoryJpa jpaRepository,
            MediaItemJpa mediaItemJpa,
            RecommendationListMapper recommendationListMapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mediaItemJpa = mediaItemJpa;
        this.recommendationListMapper = recommendationListMapper;
    }

    @Override
    public RecommendationList createList(RecommendationList recommendationList) {
        RecommendationListEntity entity =  jpaRepository.save(recommendationListMapper.toEntity(recommendationList));

        if (!entity.getMediasReferences().isEmpty()) {
            for (MediaItemEntity mediaItem : entity.getMediasReferences()) {
                mediaItemJpa.save(mediaItem);
            }
        }

        return recommendationListMapper.toDomain(entity);
    }

    @Override
    public void addMediaToRecommendationList(Media media) {
        System.out.println("Adicionadar Mídia");
    }

    @Override
    public List<RecommendationList> getListById(Long id) {
        return List.of();
    }

}
