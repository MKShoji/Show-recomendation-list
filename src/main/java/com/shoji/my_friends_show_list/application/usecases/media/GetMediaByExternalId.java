package com.shoji.my_friends_show_list.application.usecases.media;

import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetMediaByExternalId {

    private final MediaGatewayFactory mediaGatewayFactory;

    public GetMediaByExternalId(MediaGatewayFactory mediaGateway) {
        this.mediaGatewayFactory = mediaGateway;
    }

    public Optional<Media> execute(String externalId, MediaSource source) {
        return mediaGatewayFactory.exceute(source).getMediaByExternalId(externalId);
    }

}
