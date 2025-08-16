package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.domain.models.mediaItem.MediaItem;
import com.shoji.my_friends_show_list.infra.persistence.entities.MediaItemEntity;

public interface MediaItemMapper {

    MediaItemEntity toEntity(MediaItem media);
    MediaItem toDomain(MediaItemEntity entity);

}
