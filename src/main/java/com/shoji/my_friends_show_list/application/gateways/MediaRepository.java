package com.shoji.my_friends_show_list.application.gateways;

import com.shoji.my_friends_show_list.domain.models.media.Media;

import java.util.List;

public interface MediaRepository {

    public List<Media> getAllMedias();

    public Media getMediaById();
}
