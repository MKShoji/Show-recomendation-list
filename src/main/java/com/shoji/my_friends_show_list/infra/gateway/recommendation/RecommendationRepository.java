package com.shoji.my_friends_show_list.infra.gateway.recommendation;

import com.shoji.my_friends_show_list.application.gateways.RecommendationListGateway;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.domain.models.mediaItem.MediaItem;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import com.shoji.my_friends_show_list.infra.persistence.converters.mappers.MediaItemMapper;
import com.shoji.my_friends_show_list.infra.persistence.converters.mappers.RecommendationListMapper;
import com.shoji.my_friends_show_list.infra.persistence.entities.MediaItemEntity;
import com.shoji.my_friends_show_list.infra.persistence.entities.RecommendationListEntity;
import com.shoji.my_friends_show_list.infra.persistence.repository.MediaItemJpa;
import com.shoji.my_friends_show_list.infra.persistence.repository.RecommendationRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecommendationRepository implements RecommendationListGateway {

    private final RecommendationRepositoryJpa jpaRepository;
    private final MediaItemJpa mediaItemJpa;
    private final RecommendationListMapper recommendationListMapper;
    private final MediaItemMapper mediaItemMapper;

    public RecommendationRepository(
            RecommendationRepositoryJpa jpaRepository,
            MediaItemJpa mediaItemJpa,
            RecommendationListMapper recommendationListMapper, MediaItemMapper mediaItemMapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mediaItemJpa = mediaItemJpa;
        this.recommendationListMapper = recommendationListMapper;
        this.mediaItemMapper = mediaItemMapper;
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
    public RecommendationList addMediaToRecommendationList(Long listId, List<MediaItem> medias) {

        RecommendationListEntity list = jpaRepository
                .findById(listId).orElseThrow(() -> new IllegalArgumentException("Recommendations List not found"));

        if (list.getMediasReferences() == null) {
            list.setMediasReferences(new ArrayList<>());
        }

        for (MediaItem media : medias) {
            MediaItemEntity mediaEntity = mediaItemMapper.toEntity(media, list);

            boolean exists = list.getMediasReferences().stream()
                    .anyMatch(m -> m.getExternalId().equals(mediaEntity.getExternalId()));

            if (!exists) {
                list.getMediasReferences().add(mediaEntity);
            }
        }

        RecommendationListEntity saved = jpaRepository.save(list);

        return recommendationListMapper.toDomain(saved);
    }

    @Override
    public List<RecommendationList> getListByUserId(Long ownerId) {
        List<RecommendationListEntity> entities = jpaRepository.findByOwner_Id(ownerId);
        return entities.stream().map(recommendationListMapper::toDomain).collect(Collectors.toList());
    }

}
