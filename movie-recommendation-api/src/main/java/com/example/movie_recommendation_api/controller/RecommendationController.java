package com.example.movie_recommendation_api.controller;

import com.example.movie_recommendation_api.Model.Movie;
import com.example.movie_recommendation_api.Model.User;
import com.example.movie_recommendation_api.repository.UserRepository;
import com.example.movie_recommendation_api.service.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService service;
    private final UserRepository userRepository;

    public RecommendationController(RecommendationService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }

    @GetMapping("/{userId}")
    public List<Movie> recommend(@PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        return service.recommend(user);
    }
}
