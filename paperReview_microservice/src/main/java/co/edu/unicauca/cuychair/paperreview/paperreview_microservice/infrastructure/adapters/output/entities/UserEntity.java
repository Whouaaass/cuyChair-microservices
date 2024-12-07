package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities;

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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof UserEntity) {
            UserEntity other = (UserEntity) obj;
            return other.getId() == this.getId();
        }
        return super.equals(obj);
    }
}
