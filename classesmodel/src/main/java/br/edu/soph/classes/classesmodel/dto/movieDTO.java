package br.edu.soph.classes.classesmodel.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import br.edu.soph.classes.classesmodel.Model.Movie;
import br.edu.soph.classes.classesmodel.Model.Review;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class movieDTO {

    private String IMDB;
    private String title;
    private String description;
    private short releaseYear;
    private String director;
    private short duration;
    private String genre;
    private List<Review> reviews;

    public movieDTO toDTO(Movie movie) {
        return new movieDTO(movie.getIMDB(), movie.getTitle(), movie.getDescription(), movie.getReleaseYear(),
                movie.getDirector(), movie.getDuration(), movie.getGenre(), reviews);
    }

}
