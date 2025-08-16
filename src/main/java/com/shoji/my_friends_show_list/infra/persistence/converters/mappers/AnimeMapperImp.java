package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.enums.MediaType;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import net.sandrohc.jikan.model.anime.Anime;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimeMapperImp implements AnimeMapper {

    @Override
    public Media animeToMedia(Anime anime) {
        if (anime == null) return null;

        List<String> genreNames = anime.getGenres() == null ?
                List.of() :
                anime.getGenres()
                        .stream()
                        .map(genreEntity -> genreEntity.name.displayName()).toList();

        return new Media(
                String.valueOf(anime.getMalId()),
                anime.getTitle(),
                anime.getSynopsis(),
                genreNames,
                anime.getAired().getFrom().toLocalDateTime(),
                anime.getScore(),
                anime.getImages().getJpg().imageUrl,
                MediaType.ANIME,
                MediaSource.MYANIMELIST
        );
    }

}
