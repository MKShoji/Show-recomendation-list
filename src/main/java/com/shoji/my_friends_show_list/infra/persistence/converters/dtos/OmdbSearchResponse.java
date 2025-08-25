package com.shoji.my_friends_show_list.infra.persistence.converters.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OmdbSearchResponse {

    @JsonProperty("Search")
    private List<OmdbSearchResultMidia> results;

    @JsonProperty("Response")
    private String response;
}
