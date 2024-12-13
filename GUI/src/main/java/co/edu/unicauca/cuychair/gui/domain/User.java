package co.edu.unicauca.cuychair.gui.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String lastName;
    private String email;    
    private String rol;

    public User() {
    }
}
