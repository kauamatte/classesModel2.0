package br.edu.soph.classes.classesmodel.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.soph.classes.classesmodel.Model.User;
import br.edu.soph.classes.classesmodel.dto.UserDTO;
import br.edu.soph.classes.classesmodel.service.UserService;

@RestController
@RequestMapping("/users")
    public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProfile(@RequestBody UserDTO userDTO) {
        return userService.updateProfile(userDTO);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{cpf}")
    public Optional<User> findById(@PathVariable String cpf) {
        return userService.findById(cpf);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> remove(@PathVariable String cpf) {
        return userService.remove(cpf);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<UserDTO> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
    
}