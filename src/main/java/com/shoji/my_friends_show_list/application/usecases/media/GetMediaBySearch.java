package com.shoji.my_friends_show_list.application.usecases.media;

import com.shoji.my_friends_show_list.application.gateways.MediaGateway;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMediaBySearch {

    private final MediaGateway mediaGateway;

    public GetMediaBySearch(MediaGateway mediaGateway) {
        this.mediaGateway = mediaGateway;
    }

    public List<Media> execute(String query) {
        return mediaGateway.search(query);
    }
}
