package com.example.movie_recommendation_api.service;

import com.example.movie_recommendation_api.dto.TmdbMovieDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
public class TmdbClient {

    private final WebClient webClient;
    private final String apiKey;

    public TmdbClient(
            WebClient.Builder builder,
            @Value("${tmdb.api.key}") String apiKey
    ) {
        this.apiKey = apiKey.trim();
        this.webClient = builder
                .baseUrl("https://api.themoviedb.org/3")
                .defaultHeader("User-Agent", "MovieRecommendationAPI")
                .build();
    }

    public Flux<TmdbMovieDto> getPopularMovies() {
        return webClient.get()
                .uri(uri -> uri
                        .path("/movie/popular")
                        .queryParam("api_key", apiKey)
                        .queryParam("language", "pt-BR")
                        .build())
                .retrieve()
                .bodyToMono(Map.class)
                .flatMapMany(response ->
                        Flux.fromIterable((List<Map<String, Object>>) response.get("results")))
                .map(movie -> {
                    TmdbMovieDto dto = new TmdbMovieDto();
                    dto.setId(((Number) movie.get("id")).longValue());
                    dto.setTitle((String) movie.get("title"));
                    return dto;
                });
    }
}
