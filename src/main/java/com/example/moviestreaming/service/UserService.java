package com.example.moviestreaming.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String, User> userDatabase = new HashMap<>();
    private Map<String, List<String>> watchlists = new HashMap<>();

    public User createUser(String userId, String username) {
        User user = new User(userId, username);
        userDatabase.put(userId, user);
        return user;
    }

    public User getUserById(String userId) {
        return userDatabase.get(userId);
    }

    public void addToWatchlist(String userId, String movieId) {
        watchlists.computeIfAbsent(userId, k -> new ArrayList<>()).add(movieId);
    }

    public void removeFromWatchlist(String userId, String movieId) {
        List<String> watchlist = watchlists.get(userId);
        if (watchlist != null) {
            watchlist.remove(movieId);
        }
    }

    public List<String> getWatchlist(String userId) {
        return watchlists.getOrDefault(userId, new ArrayList<>());
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userDatabase.values());
    }
}

class User {
    private String userId;
    private String username;

    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    // Getters and setters omitted for brevity
}