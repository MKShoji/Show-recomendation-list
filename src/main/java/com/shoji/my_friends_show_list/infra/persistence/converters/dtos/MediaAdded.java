package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import com.shoji.my_friends_show_list.domain.enums.MediaSource;

public record MediaAdded (
        String externalId,
        MediaSource source
) {
}
