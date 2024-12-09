package co.edu.unicauca.cuychair.paper_microservice.controller.DTO;

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
    private ArrayList<Integer> authorIds;
    private ArrayList<Integer> reviewerIds;
    private Integer ownerId;
}
