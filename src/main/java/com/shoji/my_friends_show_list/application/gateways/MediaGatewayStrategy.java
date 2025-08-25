package com.shoji.my_friends_show_list.application.gateways;

import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.enums.MediaType;
import com.shoji.my_friends_show_list.domain.models.media.Media;

import java.util.List;
import java.util.Optional;

public interface MediaGatewayStrategy {
    boolean supports(MediaSource source);
    Optional<Media> getMediaByExternalId(String externalId);
    List<Media> search(String query);
}
