package br.edu.kaka.classes.classesmodel.Repository;

import br.edu.kaka.classes.classesmodel.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
}