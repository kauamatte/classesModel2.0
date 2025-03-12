package br.edu.soph.classes.classesmodel.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

import br.edu.soph.classes.classesmodel.Model.Movie;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRegisterDTO {

    private String IMDB;
    private String title;
    private String description;
    private short releaseYear;
    private String director;
    private short duration;
    private String genre;

    public Movie toModel() {
        return new Movie(null, IMDB, title, description, releaseYear, director, duration, genre, null);
    }
}
