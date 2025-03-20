package br.edu.soph.classes.classesmodel.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.soph.classes.classesmodel.Model.User;
import br.edu.soph.classes.classesmodel.Repository.UserRepository;


@Service

public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Transactional
    public User registerOrUpdate(User user){
        return userRepository.save(user);
    }
 
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(String cpf){
        return userRepository.findById(cpf);
    }
    
    @Transactional
    public void remove(String cpf) {
        userRepository.deleteById(cpf);
    }

    public Optional<User> findByName(String name){
        return userRepository.findByName(name);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}

