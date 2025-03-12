package br.edu.kaka.classes.classesmodel.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

import br.edu.kaka.classes.classesmodel.Model.Movie;
import br.edu.kaka.classes.classesmodel.Model.Review;
import br.edu.kaka.classes.classesmodel.Model.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewDTO {
    private UUID id;

    private byte rating;
    private String comment;
    private LocalDate date;
    private User user;
    private Movie movie;

    public ReviewDTO toDTO(ReviewDTO Review) {
        return new ReviewDTO(
        Review.getId(), Review.getRating(), Review.getComment(), Review.getDate(), Review.getUser(), Review.getMovie()
        );
    }


}
