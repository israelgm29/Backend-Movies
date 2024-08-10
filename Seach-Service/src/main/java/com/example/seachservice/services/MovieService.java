package com.example.seachservice.services;


import com.example.seachservice.entities.Movie;
import com.example.seachservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements BaseService<Movie> {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() throws Exception {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie findById(Integer id) throws Exception {
    Optional<Movie> movie = this.movieRepository.findById(id);
        return movie.orElse(null);
    }

    @Override
    public Movie save(Movie entity) throws Exception {
    Movie movie;
        movie = this.movieRepository.save(entity);
        return movie;
    }

    @Override
    public Movie updateOne(Movie entity, Integer id) throws Exception {
        Optional<Movie> Movie = this.movieRepository.findById(id);
        Movie MovieUpdate = Movie.get();
        MovieUpdate = this.movieRepository.save(MovieUpdate);
        return MovieUpdate;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        this.movieRepository.deleteById(id);
        return true;
    }
}
