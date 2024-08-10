package com.example.searchservice.controllers;

import com.example.searchservice.model.dtos.MovieDTO;
import com.example.searchservice.model.entities.Rent;
import com.example.searchservice.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rent")
public class RentController {
    @Autowired
    private RentService rentService;

    private RestClient restClient = RestClient.create();

    @PostMapping
    public ResponseEntity<Rent> addRent(@RequestBody Rent rent) throws Exception {
// Conexion con el microservicio de search-service
// para buscar si una pelicula esta o no disponible antes de reservar
        ResponseEntity<MovieDTO> movieDTO = restClient.get()
                .uri("http://localhost:8080/search-service/api/v1/movies/" + rent.getId_movie())
                .retrieve()
                .toEntity(MovieDTO.class);

        if (movieDTO.getBody().getStatus().equals(true)) {
            Rent rentSave = this.rentService.save(rent);
            if (rentSave != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(rentSave);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Rent>> getAllMovies() {
        try {
            List<Rent> movies = this.rentService.findAll();
            if (movies.isEmpty()) {
                return ResponseEntity.ok(Collections.emptyList());
            } else {
                return ResponseEntity.ok(movies);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
