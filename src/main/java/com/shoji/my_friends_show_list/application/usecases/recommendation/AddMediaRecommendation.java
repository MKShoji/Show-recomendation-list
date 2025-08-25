package com.shoji.my_friends_show_list.application.usecases.recommendation;

import com.shoji.my_friends_show_list.application.gateways.RecommendationListGateway;
import com.shoji.my_friends_show_list.application.usecases.media.GetMediaByExternalId;
import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.enums.MediaType;
import com.shoji.my_friends_show_list.domain.exceptions.MediaNotFoundException;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.domain.models.mediaItem.MediaItem;
import com.shoji.my_friends_show_list.domain.models.recommendation.RecommendationList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddMediaRecommendation {

    private final RecommendationListGateway recommendationListGateway;
    private final GetMediaByExternalId searchMedia;

    public AddMediaRecommendation(RecommendationListGateway recommendationListGateway, GetMediaByExternalId searchMedia) {
        this.recommendationListGateway = recommendationListGateway;
        this.searchMedia = searchMedia;
    }

    public RecommendationList execute(Long listId, List<MediaItem> medias) {

        for (MediaItem media : medias) {
            Optional<Media> mediaFound = searchMedia.execute(media.externalId(), MediaSource.MYANIMELIST);

            if(mediaFound.isEmpty()) {
                throw new MediaNotFoundException(media.externalId());
            }
        }

        return recommendationListGateway.addMediaToRecommendationList(listId, medias);
    }
}
