package com.shoji.my_friends_show_list.infra.controller;

import net.sandrohc.jikan.Jikan;
import net.sandrohc.jikan.exception.JikanQueryException;
import net.sandrohc.jikan.model.anime.Anime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/animes")
public class AnimeController {

    @GetMapping("/animeById/{animeId}")
    public ResponseEntity<Anime> getAnime(@PathVariable int animeId) {
        Jikan jikan = new Jikan();

        try {
            Anime anime = jikan.query().anime().get(animeId).execute().block();
            return ResponseEntity.ok(anime);
        } catch (JikanQueryException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
