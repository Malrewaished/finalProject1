package com.example.finalproject.service;
import com.example.finalproject.exception.ApiException;
import com.example.finalproject.model.CommentRating;
import com.example.finalproject.model.User;
import com.example.finalproject.repository.CommentRatingRepository;
import com.example.finalproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
@Service
@RequiredArgsConstructor

public class CommentRatingService {

    private final CommentRatingRepository commentRatingRepository;

    public List<CommentRating> getCommentRating() {
        return commentRatingRepository.findAll();
    }

    public void createCommentRating(CommentRating commentRating) {
        commentRatingRepository.save(commentRating);
    }

    public void updateComment(CommentRating commentRating, Integer id) {
        CommentRating oldComment = commentRatingRepository.getById(id);
        oldComment.setComment(commentRating.getComment());
        oldComment.setRating(commentRating.getRating());
        oldComment.setGrade(commentRating.getGrade());
        commentRatingRepository.save(oldComment);
    }

    public void deleteComment(Integer id) {
        commentRatingRepository.deleteById(id);
    }
}

