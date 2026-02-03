package com.example.movie_recommendation_api.repository;

import com.example.movie_recommendation_api.Model.Rating;
import com.example.movie_recommendation_api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByUser(User user);
}
