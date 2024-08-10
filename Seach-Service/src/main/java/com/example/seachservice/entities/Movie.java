package com.example.seachservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String original_language;
    private String original_title;
    private String overview;
    private Boolean status;


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", status=" + status +
                '}';
    }
}

