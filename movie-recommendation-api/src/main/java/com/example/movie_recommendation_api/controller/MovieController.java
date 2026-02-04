package com.example.movie_recommendation_api.controller;

import com.example.movie_recommendation_api.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service){
        this.service = service;
    }

    @PostMapping("/sync")
    public Mono<Void> syncMovies() {
        return service.syncMovies();
    }

}
