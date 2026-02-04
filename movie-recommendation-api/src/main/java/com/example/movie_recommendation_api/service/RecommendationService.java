package com.example.movie_recommendation_api.service;

import com.example.movie_recommendation_api.Model.Movie;
import com.example.movie_recommendation_api.Model.User;
import com.example.movie_recommendation_api.repository.MovieRepository;
import com.example.movie_recommendation_api.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;

    public RecommendationService(RatingRepository ratingRepository, MovieRepository movieRepository) {
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
    }

    public List<Movie> recommend(User user) {
        List<String> favoriteGenres =
                ratingRepository.findByUser(user).stream()
                        .filter(r -> r.getScore() >= 4)
                        .map(r -> r.getMovie().getGenre())
                        .distinct()
                        .toList();
        return movieRepository.findAll().stream()
                .filter(m -> favoriteGenres.contains(m.getGenre()))
                .toList();
    }

}