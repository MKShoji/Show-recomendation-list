package com.shoji.my_friends_show_list.application.usecases.media;

import com.shoji.my_friends_show_list.application.gateways.MediaGateway;
import com.shoji.my_friends_show_list.domain.exceptions.MediaNotFoundException;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetMidiaByExternalId {

    private final MediaGateway mediaGateway;

    public GetMidiaByExternalId(MediaGateway mediaGateway) {
        this.mediaGateway = mediaGateway;
    }

    public Optional<Media> execute(String externalId) {
        return mediaGateway.findByExternalId(externalId);
    }

}
