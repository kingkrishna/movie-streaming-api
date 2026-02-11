package com.example.moviestreaming.controller;

import com.example.moviestreaming.model.Review;
import com.example.moviestreaming.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // POST add review
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review createdReview = reviewService.addReview(review);
        return ResponseEntity.ok(createdReview);
    }

    // GET reviews for movie
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Review>> getReviewsForMovie(@PathVariable Long movieId) {
        List<Review> reviews = reviewService.getReviewsForMovie(movieId);
        return ResponseEntity.ok(reviews);
    }

    // GET average rating for movie
    @GetMapping("/movie/{movieId}/average")
    public ResponseEntity<Double> getAverageRatingForMovie(@PathVariable Long movieId) {
        Double averageRating = reviewService.getAverageRatingForMovie(movieId);
        return ResponseEntity.ok(averageRating);
    }

    // DELETE review
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}