package br.edu.soph.classes.classesmodel.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.soph.classes.classesmodel.Model.Movie;
import br.edu.soph.classes.classesmodel.Repository.MovieRepository;
import br.edu.soph.classes.classesmodel.dto.MovieDTO;
import br.edu.soph.classes.classesmodel.dto.MovieRegisterDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public ResponseEntity<MovieDTO> register(MovieRegisterDTO movieDTO) {
        Movie movie = movieDTO.toModel();
        Movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(MovieDTO.toDTO(savedMovie));
    }

    public ResponseEntity<List<MovieDTO>> findAll() {
        List<MovieDTO> movies = movieRepository.findAll().stream()
                .map(MovieDTO::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(movies);
    }

    public ResponseEntity<MovieDTO> findById(UUID id) {
        return movieRepository.findById(id)
                .map(movie -> ResponseEntity.ok(MovieDTO.toDTO(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<?> remove(UUID id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            movieRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<MovieDTO>> findByTitle(String title) {
        List<MovieDTO> movies = movieRepository.findByTitleContaining(title)
                .stream().map(MovieDTO::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(movies);
    }

    public ResponseEntity<List<MovieDTO>> findByReleaseYear(short year) {
        List<MovieDTO> movies = movieRepository.findByReleaseYear(year)
                .stream().map(MovieDTO::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(movies);
    }

    public ResponseEntity<List<MovieDTO>> findByGenre(String genre) {
        List<MovieDTO> movies = movieRepository.findByGenreContaining(genre)
                .stream().map(MovieDTO::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(movies);
    }
}
