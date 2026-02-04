package com.example.movie_recommendation_api.service;

import com.example.movie_recommendation_api.Model.Movie;
import com.example.movie_recommendation_api.repository.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    private final MovieRepository repository;
    private final TmdbClient tmdbClient;

    public MovieService(MovieRepository repository, TmdbClient tmdbClient) {
        this.repository = repository;
        this.tmdbClient = tmdbClient;
    }

    public Mono<Void> syncMovies() {
        return tmdbClient.getPopularMovies()
                .doOnNext(dto ->
                        repository.findByTmdbId(dto.getId())
                                .orElseGet(() ->
                                        repository.save(
                                                new Movie(null, dto.getId(), dto.getTitle(), "POPULAR")
                                        )
                                )
                )
                .then();
    }
}