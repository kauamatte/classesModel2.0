package br.edu.soph.classes.classesmodel.dto;

import br.edu.soph.classes.classesmodel.Model.Movie;
import br.edu.soph.classes.classesmodel.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String cpf;
    private String name;
    private String email;

    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getCpf(), user.getName(), user.getEmail());
    }

}
