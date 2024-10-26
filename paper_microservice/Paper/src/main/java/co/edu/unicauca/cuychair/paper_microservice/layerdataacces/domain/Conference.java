package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
public class Conference {

    private int id;
    private String title;
    private String subject;
    private String description;

    public Conference(){}

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Conference){
            return Objects.equals(id, ((Conference) obj).getId());
        }
        return false;
    }
}
