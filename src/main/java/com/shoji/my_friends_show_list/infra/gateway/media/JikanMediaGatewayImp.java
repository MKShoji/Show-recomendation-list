package com.shoji.my_friends_show_list.infra.gateway.media;

import com.shoji.my_friends_show_list.application.gateways.MediaGatewayStrategy;
import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.infra.persistence.converters.mappers.AnimeMapper;
import net.sandrohc.jikan.Jikan;
import net.sandrohc.jikan.exception.JikanQueryException;
import net.sandrohc.jikan.model.anime.Anime;
import net.sandrohc.jikan.model.anime.AnimeOrderBy;
import net.sandrohc.jikan.model.enums.SortOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JikanMediaGatewayImp implements MediaGatewayStrategy {

    private final Jikan jikan;
    private final AnimeMapper animeMapper;

    public JikanMediaGatewayImp(Jikan jikan, AnimeMapper animeMapper) {
        this.jikan = jikan;
        this.animeMapper = animeMapper;
    }

    @Override
    public boolean supports(MediaSource source) {
        return MediaSource.MYANIMELIST.equals(source);
    }

    @Override
    public Optional<Media> getMediaByExternalId(String externalId) {
        int jinkanId = Integer.parseInt(externalId);

        try {
            Anime anime = jikan.query().anime().get(jinkanId).execute().block();

            if (anime == null) {
                return Optional.empty();
            }

            return Optional.of(anime).map(animeMapper::animeToMedia);
        } catch (JikanQueryException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Media> search(String query) {

        try {
            List<Anime> results = jikan.query().anime().search()
                    .query(query)
                    .limit(5)
                    .orderBy(AnimeOrderBy.SCORE, SortOrder.DESCENDING)
                    .execute()
                    .collectList()
                    .block();

            if (results == null) {
                return List.of();
            }

            return results.stream().map(animeMapper::animeToMedia).collect(Collectors.toList());
        } catch (JikanQueryException e) {
            throw new RuntimeException(e);
        }
    }
}