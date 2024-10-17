package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String email;

    public User(){}
}
