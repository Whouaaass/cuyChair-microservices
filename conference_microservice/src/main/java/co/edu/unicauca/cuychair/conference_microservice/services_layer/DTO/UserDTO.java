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
    private String name;    
    private String lastname;
    private String email;
    private String phone;
    private String description;    

    public UserDTO() {}   

    @Override
    public String toString() {
        return "UserDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
