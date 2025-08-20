package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.domain.models.mediaItem.MediaItem;
import com.shoji.my_friends_show_list.infra.persistence.entities.MediaItemEntity;
import com.shoji.my_friends_show_list.infra.persistence.entities.RecommendationListEntity;

public interface MediaItemMapper {

    MediaItemEntity toEntity(MediaItem media, RecommendationListEntity parent);
    MediaItem toDomain(MediaItemEntity entity);

}
