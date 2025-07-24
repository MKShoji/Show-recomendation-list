package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.infra.persistence.entities.MediaEntity;

public class MediaMapper {

    public MediaEntity toEntity(Media media) {
        MediaEntity mediaEntity = new MediaEntity();

        mediaEntity.setId(media.id());
        mediaEntity.setTitle(media.title());
        mediaEntity.setDescription(media.description());
        mediaEntity.setReleaseDate(media.releaseDate());
        mediaEntity.setMediaType(media.mediaType());
        return mediaEntity;
    }

    public Media toDomain(MediaEntity e) {
        return new Media(
                e.getId(),
                e.getTitle(),
                e.getDescription(),
                e.getReleaseDate(),
                e.getMediaType()
        );
    }
}
