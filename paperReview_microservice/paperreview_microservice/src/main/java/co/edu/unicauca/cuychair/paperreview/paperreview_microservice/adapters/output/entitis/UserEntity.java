package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entitis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserEntity {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String description;
    private int phone;
}
