package br.edu.kaka.classes.classesmodel.Repository;

import br.edu.kaka.classes.classesmodel.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}