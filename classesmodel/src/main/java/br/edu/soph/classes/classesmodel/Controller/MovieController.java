package br.edu.soph.classes.classesmodel.Controller;

import br.edu.soph.classes.classesmodel.dto.movieDTO;
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
    public ResponseEntity<Object> register(@RequestBody MovieRegisterDTO movieDTO) {
        return movieService.register(movieDTO);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody MovieRegisterDTO movieDTO) {
        return ResponseEntity.ok().build(); 
    }

    @GetMapping("/all")
    public ResponseEntity<List<movieDTO>> findAll() {
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
    public ResponseEntity<List<movieDTO>> findByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<movieDTO>> findByReleaseYear(@PathVariable short year) {
        return movieService.findByReleaseYear(year);
    }

    @GetMapping("/director/{name}")
    public ResponseEntity<List<movieDTO>> findByDirector(@PathVariable String name) {
        return ResponseEntity.ok().build(); 
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<movieDTO>> findByGenre(@PathVariable String genre) {
        return movieService.findByGenre(genre);
    }
}
