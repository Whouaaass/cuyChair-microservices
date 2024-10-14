package co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * Data transfer object for User
 */
@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String nombre;    
    private String email;
    private String phone;
    private String description;    

    public UserDTO() {}   
}
