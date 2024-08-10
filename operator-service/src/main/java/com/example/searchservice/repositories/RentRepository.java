package com.example.searchservice.repositories;

import com.example.searchservice.model.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Integer> {
}
