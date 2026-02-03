package com.example.movie_recommendation_api.repository;

import com.example.movie_recommendation_api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
