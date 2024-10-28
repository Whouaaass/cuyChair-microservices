package co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RabbitUserDTO {    
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String description;
    private int phone;

    public RabbitUserDTO(){}
}
