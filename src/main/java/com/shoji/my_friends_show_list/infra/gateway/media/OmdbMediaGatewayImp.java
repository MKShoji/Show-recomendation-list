package com.shoji.my_friends_show_list.infra.gateway.media;

import com.shoji.my_friends_show_list.application.gateways.MediaGatewayStrategy;
import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.exceptions.MediaNotFoundException;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.infra.config.OmdbConfig;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.OmdbResponse;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.OmdbSearchResponse;
import com.shoji.my_friends_show_list.infra.persistence.converters.mappers.OmdbMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class OmdbMediaGatewayImp implements MediaGatewayStrategy {

    private final RestTemplate restTemplate;
    private final OmdbConfig config;
    private final OmdbMapper omdbMapper;

    public OmdbMediaGatewayImp(RestTemplate restTemplate, OmdbConfig config, OmdbMapper omdbMapper) {
        this.restTemplate = restTemplate;
        this.config = config;
        this.omdbMapper = omdbMapper;
    }

    @Override
    public boolean supports(MediaSource source) {
        return MediaSource.IMDB.equals(source);
    }

    @Override
    public Optional<Media> getMediaByExternalId(String imdbId) {
        String url = config.getUrl() + "?apikey=" + config.getKey() + "&i=" + imdbId;
        OmdbResponse response = restTemplate.getForObject(url, OmdbResponse.class);

        if ("False".equalsIgnoreCase(response != null ? response.getResponse() : null)) {
            throw new MediaNotFoundException("Movie not found in OMDB: " + response.getResponse());
        }

        return Optional.of(omdbMapper.toDomain(response));
    }

    @Override
    public List<Media> search(String title) {
        String url = config.getUrl() + "?apikey=" + config.getKey() + "&s=" + title;
        OmdbSearchResponse response = restTemplate.getForObject(url, OmdbSearchResponse.class);

        return omdbMapper.toDomain(response);
    }
}
