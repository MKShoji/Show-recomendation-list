package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.AnimeDto;
import net.sandrohc.jikan.model.anime.Anime;

public class AnimeMapper {

    public static AnimeDto toAnimeDto(Anime anime) {
        if (anime == null) {
            return null;
        }

        return AnimeDto.
                builder().
                malId(anime.getMalId()).
                title(anime.getTitle()).
                synopsis(anime.getSynopsis()).
                build();
    }
}
