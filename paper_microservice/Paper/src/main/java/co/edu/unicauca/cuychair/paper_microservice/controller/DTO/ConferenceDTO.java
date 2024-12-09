package co.edu.unicauca.cuychair.paper_microservice.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class ConferenceDTO {
    private int id;
    private String title;
    private String city;
    private Date date;

    private ArrayList<Integer> reviewers;
    private ArrayList<Integer> authors;

    private Integer owner;

}
