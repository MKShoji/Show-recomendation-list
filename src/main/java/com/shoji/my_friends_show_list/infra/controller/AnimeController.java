package com.shoji.my_friends_show_list.infra.controller;

import com.shoji.my_friends_show_list.application.usecases.media.GetMediaBySearch;
import com.shoji.my_friends_show_list.application.usecases.media.GetMediaByExternalId;
import com.shoji.my_friends_show_list.domain.models.media.Media;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animes")
public class AnimeController {

    private final GetMediaByExternalId getMidiaByExternalId;
    private final GetMediaBySearch getMediaBySearch;

    public AnimeController(GetMediaByExternalId getMidiaByExternalId, GetMediaBySearch getMediaBySearch) {
        this.getMidiaByExternalId = getMidiaByExternalId;
        this.getMediaBySearch = getMediaBySearch;
    }

    @GetMapping("/animeById/{animeId}")
    public ResponseEntity<Media> getAnime(@PathVariable int animeId) {
         return getMidiaByExternalId.execute(String.valueOf(animeId))
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Media>> searchAnime(@RequestParam String name) {
        List<Media> results = getMediaBySearch.execute(name);

        if(results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(results);
    }
}