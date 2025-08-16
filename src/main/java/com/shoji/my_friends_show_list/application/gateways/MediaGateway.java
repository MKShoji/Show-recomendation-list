package com.shoji.my_friends_show_list.application.gateways;

import com.shoji.my_friends_show_list.domain.models.media.Media;

import java.util.List;
import java.util.Optional;

public interface MediaGateway {
    Optional<Media> findByExternalId(String externalId);
    List<Media> search(String query);
}
