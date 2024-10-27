package co.edu.unicauca.cuychair.paper_microservice.domain;

import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
public class Conference {

    private int id;
    private String title;
    private String city;
    private String date;
    private ArrayList<User> participantsList;
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