package com.shoji.my_friends_show_list.infra.persistence.converters.mappers;

import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.enums.MediaType;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.OmdbResponse;
import com.shoji.my_friends_show_list.infra.persistence.converters.dtos.OmdbSearchResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class OmdbMapperImp implements OmdbMapper {
    @Override
    public Media toDomain(OmdbResponse response) {
        List<String> genres = parseGenres(response.getGenre());

        return new Media(
                response.getImdbID(),
                response.getTitle(),
                response.getPlot(),
                genres,
                parseReleaseDate(response.getReleaseDate()),
                Double.valueOf(response.getImdbRating()),
                response.getPoster(),
                parseMediaType(response.getType()),
                response.getSource()
        );
    }

    @Override
    public List<Media> toDomain(OmdbSearchResponse response) {

        return response.getResults().stream()
                .map(result -> new Media(
                        result.getImdbID(),
                        result.getTitle(),
                        null,
                        null,
                        null,
                        null,
                        result.getPoster(),
                        parseMediaType(result.getType()),
                        MediaSource.IMDB
                )).toList();
    }

    private List<String> parseGenres(String genre) {
        if (genre == null || genre.isBlank()) return List.of();

        return Arrays.stream(genre.split(","))
                .map(String::trim)
                .toList();
    }

    private LocalDateTime parseReleaseDate(String releaseDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
            return LocalDate.parse(releaseDate, formatter).atStartOfDay();
        } catch (Exception e) {
            return null;
        }
    }

    private MediaType parseMediaType(String type) {
        return switch (type) {
            case "series" -> MediaType.SERIES;
            case "movie" -> MediaType.MOVIE;
            default -> null;
        };
    }
}
