package co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String email;


}
