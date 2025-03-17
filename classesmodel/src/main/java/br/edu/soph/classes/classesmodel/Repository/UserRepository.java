package br.edu.soph.classes.classesmodel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.soph.classes.classesmodel.Model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);
}