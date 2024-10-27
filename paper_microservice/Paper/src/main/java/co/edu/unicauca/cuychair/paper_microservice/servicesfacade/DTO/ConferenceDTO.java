package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
public class ConferenceDTO {
    private int id;
    private String title;
    private String city;
    private String date;
    private ArrayList<UserDTO> participantsList;
    private UserDTO owner;

}
