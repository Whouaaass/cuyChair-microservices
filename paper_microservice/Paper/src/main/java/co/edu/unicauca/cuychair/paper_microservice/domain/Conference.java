package co.edu.unicauca.cuychair.paper_microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
public class Conference {

    private Integer id;
    private String title;
    private String city;
    private String date;

    private ArrayList<User> reviewers;
    private ArrayList<User> authors;

    private User owner;

    public Conference(){}


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Conference){
            return Objects.equals(id, ((Conference) obj).getId());
        }
        return false;
    }
}
