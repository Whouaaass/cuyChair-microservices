package co.edu.unicauca.cuychair.paper_microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String description;
    private int phone;

    public User(){}

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            return id == ((User)obj).id;
        }
        return false;
    }
}
