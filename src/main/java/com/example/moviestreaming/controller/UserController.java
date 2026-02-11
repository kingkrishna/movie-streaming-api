package com.example.moviestreaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST: Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // GET: Retrieve user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST: Add user to watchlist
    @PostMapping("/{id}/watchlist")
    public ResponseEntity<Void> addToWatchlist(@PathVariable Long id, @RequestBody Movie movie) {
        userService.addToWatchlist(id, movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // DELETE: Remove user from watchlist
    @DeleteMapping("/{id}/watchlist/{movieId}")
    public ResponseEntity<Void> removeFromWatchlist(@PathVariable Long id, @PathVariable Long movieId) {
        userService.removeFromWatchlist(id, movieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // GET: Get user's watchlist
    @GetMapping("/{id}/watchlist")
    public ResponseEntity<List<Movie>> getWatchlist(@PathVariable Long id) {
        List<Movie> watchlist = userService.getWatchlist(id);
        return new ResponseEntity<>(watchlist, HttpStatus.OK);
    }

    // GET: Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}