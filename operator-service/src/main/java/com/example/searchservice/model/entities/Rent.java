package com.example.searchservice.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "rent")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Boolean rent;
    private String currentName;
    private Date rent_start;
    private Date rent_expired;
    private int id_movie;

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", rent=" + rent +
                ", currentName='" + currentName + '\'' +
                ", rent_start=" + rent_start +
                ", rent_expired=" + rent_expired +
                ", id_movie=" + id_movie +
                '}';
    }
}
