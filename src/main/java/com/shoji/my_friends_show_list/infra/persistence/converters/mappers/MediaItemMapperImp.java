package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;


import com.shoji.my_friends_show_list.domain.models.mediaItem.MediaItem;
import com.shoji.my_friends_show_list.infra.persistence.entities.MediaItemEntity;
import com.shoji.my_friends_show_list.infra.persistence.entities.RecommendationListEntity;
import org.springframework.stereotype.Component;

@Component
public class MediaItemMapperImp implements MediaItemMapper {

    @Override
    public MediaItemEntity toEntity(MediaItem media, RecommendationListEntity parent) {
        if (media == null) return null;

        MediaItemEntity entity = new MediaItemEntity();
        entity.setId(media.id());
        entity.setExternalId(media.externalId());
        entity.setSource(media.mediaSource());
        entity.setRecommendationList(parent);

        return entity;
    }

    @Override
    public MediaItem toDomain(MediaItemEntity entity) {
        if (entity == null) return null;

        return new MediaItem(
                entity.getId(),
                entity.getExternalId(),
                entity.getSource()
        );
    }
}
