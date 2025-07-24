package com.shoji.my_friends_show_list.infra.gateway;

import com.shoji.my_friends_show_list.application.gateways.MediaRepository;
import com.shoji.my_friends_show_list.domain.models.media.Media;

import java.util.List;

public class MediaJpaRepository implements MediaRepository {


    @Override
    public List<Media> getAllMedias() {
        return List.of();
    }

    @Override
    public Media getMediaById() {
        return null;
    }
}
