package co.edu.unicauca.cuychair.conference_microservice.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private Integer id; // aqui el id no es utlizado pero se supone se debe de utilizar despues al crear cosas relacionales y además siempre no esta de más tener un id identificador del usuario porque siempre facilita su diferenciacion
    private String name;
    private String email;
    private String phone;
    private String description;

    public User() {}

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
