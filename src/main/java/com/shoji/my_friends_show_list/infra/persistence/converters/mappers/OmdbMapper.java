package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.OmdbResponse;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.OmdbSearchResponse;

import java.util.List;

public interface OmdbMapper {
    Media toDomain(OmdbResponse response);
    List<Media> toDomain(OmdbSearchResponse response);
}
