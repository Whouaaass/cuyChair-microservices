package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Paper {

    private int id;
    private String title;
    private String description;
    private User author;
    private Conference conference;

    public Paper(){}

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Paper){
            return id == ((Paper) obj).getId();
        }
        return false;
    }
}
