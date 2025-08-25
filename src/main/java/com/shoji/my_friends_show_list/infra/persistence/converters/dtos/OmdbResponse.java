package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import lombok.Data;

@Data
public class OmdbResponse {
    private String imdbID;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Released")
    private String releaseDate;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Response")
    private String response;

    private MediaSource source = MediaSource.IMDB;
}
