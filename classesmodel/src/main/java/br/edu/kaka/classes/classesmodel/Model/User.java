package br.edu.kaka.classes.classesmodel.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    
    private String cpf;
    
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}