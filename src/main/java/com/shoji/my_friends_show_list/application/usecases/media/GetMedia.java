package com.shoji.my_friends_show_list.application.usecases.media;

import com.shoji.my_friends_show_list.application.gateways.MediaRepository;
import com.shoji.my_friends_show_list.domain.models.media.Media;

import java.util.List;

public class GetMedia  {

    private final MediaRepository mediaRepository;

    public GetMedia(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<Media> getAllMedia() {
        return mediaRepository.getAllMedias();
    }
}
