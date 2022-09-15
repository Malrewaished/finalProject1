package com.example.finalproject.repository;
import com.example.finalproject.model.CommentRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRatingRepository extends JpaRepository<CommentRating, Integer> {
}