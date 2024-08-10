package com.example.seachservice.controllers;


import com.example.seachservice.entities.Movie;
import com.example.seachservice.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/movies")

public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        try {
            Movie createMovie = this.movieService.save(movie);
            if (createMovie !=null){
                return ResponseEntity.status(HttpStatus.CREATED).body(createMovie);
            }else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Movie>> getAllMovies() {
        try {
            List<Movie> movies = this.movieService.findAll();
            if (movies.isEmpty()){
                return ResponseEntity.ok(Collections.emptyList());
            }else {
                return ResponseEntity.ok(movies);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id, HttpMethod httpMethod) throws Exception {

        Movie movie = movieService.findById(id);
        if (movie != null){
            return ResponseEntity.ok(movie);
        }else
            return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        try {
            Movie movieOptional = this.movieService.findById(id);
            if (movieOptional != null) {
                Movie movieUpdate = new Movie();
                movieUpdate.setStatus(movie.getStatus());
                movieUpdate.setTitle(movie.getTitle());
                movieUpdate.setOverview(movie.getOverview());
                movieUpdate.setOriginal_language(movie.getOriginal_language());
                movieUpdate.setOriginal_title(movie.getOriginal_title());
                this.movieService.save(movieUpdate);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        try {
            Boolean removed = movieService.deleteById(id);
            if (Boolean.TRUE.equals(removed)){
                return ResponseEntity.ok().build();
            }else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
