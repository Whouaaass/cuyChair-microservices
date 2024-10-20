package co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {
    public ConferenceDTO(){};
    private int id;
    private String title;
    private String city;
    private String date;
    private ArrayList<UserDTO> participantsList;
    private UserDTO owner;
}
