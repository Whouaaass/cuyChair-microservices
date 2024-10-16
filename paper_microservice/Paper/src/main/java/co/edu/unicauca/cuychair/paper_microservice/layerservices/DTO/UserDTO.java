package co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private long id;
    private String name;
    private String email;

    public UserDTO() {}

}
