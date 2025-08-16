package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import com.shoji.my_friends_show_list.infra.persistence.entities.RecommendationListEntity;
import com.shoji.my_friends_show_list.infra.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecommendationMapperImp implements  RecommendationListMapper {

    private final MediaItemMapper mediaItemMapper;

    public RecommendationMapperImp(MediaItemMapper mediaItemMapper) {
        this.mediaItemMapper = mediaItemMapper;
    }

    @Override
    public RecommendationList toDomain(RecommendationListEntity entity) {
        if (entity == null) return null;

        Long ownerId = null;
        if (entity.getOwner() != null) {
            ownerId = entity.getOwner().getId();
        }

        return new RecommendationList(
                entity.getId(),
                ownerId,
                entity.getName(),
                entity.getMediasReferences().stream().map(mediaItemMapper::toDomain).toList(),
                entity.getVisibility(),
                entity.getCreatedAt()
        );
    }

    @Override
    public RecommendationListEntity toEntity(RecommendationList recommendationList) {
        if (recommendationList == null) return null;

        RecommendationListEntity entity = new RecommendationListEntity();
        entity.setId(recommendationList.id());

        if (recommendationList.ownerId() != null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(recommendationList.ownerId());
            entity.setOwner(userEntity);
        }

        entity.setName(recommendationList.name());
        entity.setVisibility(recommendationList.visibility());
        entity.setCreatedAt(recommendationList.createdAt());

        entity.setMediasReferences(
                recommendationList.medias() == null
                        ? List.of()
                        : recommendationList.medias().stream()
                        .map(mediaItemMapper::toEntity)
                        .toList()
        );

        return entity;
    }

}
