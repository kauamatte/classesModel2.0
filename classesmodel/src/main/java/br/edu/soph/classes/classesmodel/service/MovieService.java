package br.edu.soph.classes.classesmodel.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.soph.classes.classesmodel.Model.Movie;
import br.edu.soph.classes.classesmodel.Repository.MovieRepository;
import br.edu.soph.classes.classesmodel.dto.movieDTO;
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
    public ResponseEntity<Object> register(MovieRegisterDTO movieDTO) {
        Movie movie = movieDTO.toModel();
        Movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(movieDTO.toDTO(savedMovie));
    }

    public ResponseEntity<List<movieDTO>> findAll() {
        List<movieDTO> movies = movieRepository.findAll().stream()
                .map(movieDTO::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(movies);
    }

    public ResponseEntity<movieDTO> findById(UUID id) {
        return movieRepository.findById(id)
                .map(movie -> ResponseEntity.ok(movieDTO.toDTO(movie)))
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

    public ResponseEntity<List<movieDTO>> findByTitle(String title) {
        List<movieDTO> movies = movieRepository.findByTitleContaining(title)
                .stream().map(movieDTO::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(movies);
    }

    public ResponseEntity<List<movieDTO>> findByReleaseYear(short year) {
        List<movieDTO> movies = movieRepository.findByReleaseYear(year)
                .stream().map(movieDTO::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(movies);
    }

    public ResponseEntity<List<movieDTO>> findByGenre(String genre) {
        List<movieDTO> movies = movieRepository.findByGenreContaining(genre)
                .stream().map(movieDTO::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(movies);
    }
}
