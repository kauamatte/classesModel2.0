package br.edu.soph.classes.classesmodel.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

import br.edu.soph.classes.classesmodel.Model.Movie;
import br.edu.soph.classes.classesmodel.Model.Review;
import br.edu.soph.classes.classesmodel.Model.User;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRegisterDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private UUID id;
    private byte rating;
    private String comment;
    private LocalDate date;
    private String author;
    private String userCPF;
    private String movieIMDB;

        public Review toModel(User user, Movie movie) {
        return new Review(id, rating, comment, date, author, user, movie);
    }


}
