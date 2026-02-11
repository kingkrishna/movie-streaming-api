package com.example.moviestreaming.model;

import java.util.List;
import java.util.Date;

public class User {
    private String userId;
    private String username;
    private String email;
    private String subscriptionTier;
    private List<String> watchlistMovies;
    private Date createdAt;

    public User(String userId, String username, String email, String subscriptionTier, List<String> watchlistMovies, Date createdAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.subscriptionTier = subscriptionTier;
        this.watchlistMovies = watchlistMovies;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubscriptionTier() {
        return subscriptionTier;
    }

    public void setSubscriptionTier(String subscriptionTier) {
        this.subscriptionTier = subscriptionTier;
    }

    public List<String> getWatchlistMovies() {
        return watchlistMovies;
    }

    public void setWatchlistMovies(List<String> watchlistMovies) {
        this.watchlistMovies = watchlistMovies;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}