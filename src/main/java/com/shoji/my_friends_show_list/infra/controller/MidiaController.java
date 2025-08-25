package com.shoji.my_friends_show_list.infra.controller;

import com.shoji.my_friends_show_list.application.usecases.media.GetMediaByExternalId;
import com.shoji.my_friends_show_list.application.usecases.media.GetMediaBySearch;
import com.shoji.my_friends_show_list.domain.enums.MediaSource;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/midias")
public class MidiaController {

    private final GetMediaByExternalId getMidiaByExternalId;
    private final GetMediaBySearch getMediaBySearch;

    public MidiaController(GetMediaByExternalId getMidiaByExternalId, GetMediaBySearch getMediaBySearch) {
        this.getMidiaByExternalId = getMidiaByExternalId;
        this.getMediaBySearch = getMediaBySearch;
    }

    @GetMapping("/omdb/{imdbId}")
    public ResponseEntity<Media> getMidiaImdb(@PathVariable String imdbId) {
        return getMidiaByExternalId.execute(imdbId, MediaSource.IMDB)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/omdb/search")
    public ResponseEntity<List<Media>> searchAnime(@RequestParam String name) {
        List<Media> results = getMediaBySearch.execute(name, MediaSource.IMDB);

        if(results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(results);
    }
}
