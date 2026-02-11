package com.example.moviestreaming.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewService {
    private Map<String, List<Review>> movieReviews = new HashMap<>();

    public void addReview(String movieId, Review review) {
        movieReviews.computeIfAbsent(movieId, k -> new ArrayList<>()).add(review);
    }

    public List<Review> getReviewsForMovie(String movieId) {
        return movieReviews.getOrDefault(movieId, new ArrayList<>());
    }

    public double getAverageRating(String movieId) {
        List<Review> reviews = movieReviews.get(movieId);
        if (reviews == null || reviews.isEmpty()) {
            return 0;
        }
        return reviews.stream().mapToInt(Review::getRating).average().orElse(0);
    }

    public void deleteReview(String movieId, Review review) {
        List<Review> reviews = movieReviews.get(movieId);
        if (reviews != null) {
            reviews.remove(review);
        }
    }
}

class Review {
    private String userId;
    private String comment;
    private int rating;

    public Review(String userId, String comment, int rating) {
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
}