package com.example.moviestreaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.moviestreaming.model.Movie;
import com.example.moviestreaming.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // POST: Add a new movie
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    // GET: Retrieve all movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // GET: Retrieve movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        return movie != null ? new ResponseEntity<>(movie, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET: Retrieve movies by genre
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
        List<Movie> movies = movieService.getMoviesByGenre(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // GET: Search movies
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String query) {
        List<Movie> movies = movieService.searchMovies(query);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // GET: Retrieve trending movies
    @GetMapping("/trending")
    public ResponseEntity<List<Movie>> getTrendingMovies() {
        List<Movie> movies = movieService.getTrendingMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // GET: Retrieve recommendations
    @GetMapping("/recommendations")
    public ResponseEntity<List<Movie>> getRecommendations() {
        List<Movie> movies = movieService.getRecommendations();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // PUT: Update an existing movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(id, movie);
        return updatedMovie != null ? new ResponseEntity<>(updatedMovie, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE: Delete a movie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        boolean isDeleted = movieService.deleteMovie(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}