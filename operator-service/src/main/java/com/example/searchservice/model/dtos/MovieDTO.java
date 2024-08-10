package com.example.searchservice.model.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDTO {
    private int id;

    private String title;
    private String original_language;
    private String original_title;
    private String overview;
    private Boolean status;
}
