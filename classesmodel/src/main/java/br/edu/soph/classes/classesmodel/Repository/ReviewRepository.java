package br.edu.soph.classes.classesmodel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.soph.classes.classesmodel.Model.Review;
import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {

    List<Review> findByAuthor(String author);
}