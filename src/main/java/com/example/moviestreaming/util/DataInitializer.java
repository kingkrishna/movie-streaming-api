package com.example.moviestreaming.util;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Initialize sample movies
        initializeMovies();
        // Initialize sample users
        initializeUsers();
        // Initialize sample reviews
        initializeReviews();
    }

    private void initializeMovies() {
        // Sample movie data initialization logic here
        System.out.println("Sample movies initialized.");
    }

    private void initializeUsers() {
        // Sample user data initialization logic here
        System.out.println("Sample users initialized.");
    }

    private void initializeReviews() {
        // Sample review data initialization logic here
        System.out.println("Sample reviews initialized.");
    }
}