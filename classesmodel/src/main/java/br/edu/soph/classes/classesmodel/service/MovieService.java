package br.edu.soph.classes.classesmodel.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.soph.classes.classesmodel.Model.Movie;
import br.edu.soph.classes.classesmodel.Repository.MovieRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public Movie register(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(UUID id) {
        return movieRepository.findById(id);
    }

    @Transactional
    public void remove(UUID id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> findByTitle(String title){
        return movieRepository.findByTitleContaining(title);
    }

    public List<Movie> findByReleaseYear(short year){
        return movieRepository.findByReleaseYear(year);
    }

    public List<Movie> findByGenre(String genre){
        return movieRepository.findByGenreContaining(genre);
    }
}
