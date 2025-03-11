package br.edu.kaka.classes.classesmodel.Repository;

import br.edu.kaka.classes.classesmodel.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}