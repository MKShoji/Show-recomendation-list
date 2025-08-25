package com.shoji.my_friends_show_list.application.usecases.media;

import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMediaBySearch {

    private final MediaGatewayFactory mediaGatewayFactory;

    public GetMediaBySearch(MediaGatewayFactory mediaGateway) {
        this.mediaGatewayFactory = mediaGateway;
    }

    public List<Media> execute(String query, MediaSource source) {
        return mediaGatewayFactory.exceute(source).search(query);
    }
}
