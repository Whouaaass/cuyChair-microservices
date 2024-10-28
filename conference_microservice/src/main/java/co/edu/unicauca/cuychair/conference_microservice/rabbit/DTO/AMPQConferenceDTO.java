package co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AMPQConferenceDTO {    
    private int id;
    private String title;
    private String city;
    private String date;
    private List<Integer> authorIds;
    private List<Integer> reviewerIds;
    private Integer ownerId;

    public AMPQConferenceDTO(){};
}