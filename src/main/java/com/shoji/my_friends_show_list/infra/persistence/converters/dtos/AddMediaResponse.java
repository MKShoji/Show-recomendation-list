package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import java.util.List;

public record AddMediaResponse(
        Long listId,
        List<MediaAdded> media
) {
}
