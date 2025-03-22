package br.edu.soph.classes.classesmodel.Controller;

import br.edu.soph.classes.classesmodel.dto.MovieDTO;
import br.edu.soph.classes.classesmodel.dto.MovieRegisterDTO;
import br.edu.soph.classes.classesmodel.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/register")
    public ResponseEntity<MovieDTO> register(@RequestBody MovieRegisterDTO movieDTO) {
        return movieService.register(movieDTO);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody MovieRegisterDTO movieDTO) {
        return ResponseEntity.ok().build(); // Implementar lógica de edição no serviço
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return movieService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable UUID id) {
        return movieService.remove(id);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<MovieDTO>> findByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<MovieDTO>> findByReleaseYear(@PathVariable short year) {
        return movieService.findByReleaseYear(year);
    }

    @GetMapping("/director/{name}")
    public ResponseEntity<List<MovieDTO>> findByDirector(@PathVariable String name) {
        return ResponseEntity.ok().build(); // Implementar no serviço
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieDTO>> findByGenre(@PathVariable String genre) {
        return movieService.findByGenre(genre);
    }
}
