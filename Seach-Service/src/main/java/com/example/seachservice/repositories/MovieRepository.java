package com.example.seachservice.repositories;


import com.example.seachservice.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
