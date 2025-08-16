package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;


import com.shoji.my_friends_show_list.domain.models.mediaItem.MediaItem;
import com.shoji.my_friends_show_list.infra.persistence.entities.MediaItemEntity;
import com.shoji.my_friends_show_list.infra.persistence.entities.RecommendationListEntity;
import org.springframework.stereotype.Component;

@Component
public class MediaItemMapperImp implements MediaItemMapper {

    @Override
    public MediaItemEntity toEntity(MediaItem media) {
        if (media == null) return null;

        MediaItemEntity entity = new MediaItemEntity();
        entity.setId(media.id());

        if(media.recommendationListId() != null) {
            RecommendationListEntity listEntity = new RecommendationListEntity();
            listEntity.setId(media.recommendationListId());
            entity.setRecommendationList(listEntity);
        }
        entity.setExternalId(media.externalId());
        entity.setSource(media.mediaSource());

        return entity;
    }

    @Override
    public MediaItem toDomain(MediaItemEntity entity) {
        if (entity == null) return null;

        Long recommendationListId = null;
        if (entity.getRecommendationList() != null) {
            recommendationListId = entity.getRecommendationList().getId();
        }

        return new MediaItem(
                entity.getId(),
                recommendationListId,
                entity.getExternalId(),
                entity.getSource()
        );
    }
}
