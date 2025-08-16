package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.models.media.Media;
import net.sandrohc.jikan.model.GenreEntity;
import net.sandrohc.jikan.model.anime.Anime;

import java.util.List;

public interface AnimeMapper {
    Media animeToMedia(Anime anime);
}
