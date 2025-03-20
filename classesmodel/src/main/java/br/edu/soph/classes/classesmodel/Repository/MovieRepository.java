package br.edu.soph.classes.classesmodel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.soph.classes.classesmodel.Model.Movie;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleContaining(String title);

    List<Movie> findByReleaseYear(short year);

    List<Movie> findByDirectorContaining(String name);

    List<Movie> findByGenreContaining(String genre);

    Optional<Movie> findById(UUID id);

    void deleteById(UUID id);

    

}