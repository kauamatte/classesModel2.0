package br.edu.soph.classes.classesmodel.dto;

import lombok.*;

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

    public Object toDTO(Movie savedMovie) {
        throw new UnsupportedOperationException("Unimplemented method 'toDTO'");
    }
}
