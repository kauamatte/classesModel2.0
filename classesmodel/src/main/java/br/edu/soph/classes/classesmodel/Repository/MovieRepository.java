package br.edu.soph.classes.classesmodel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.soph.classes.classesmodel.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}