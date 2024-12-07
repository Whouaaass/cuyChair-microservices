package co.edu.unicauca.cuychair.paper_microservice.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String description;
    private int phone;

}
