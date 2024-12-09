package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.dto;

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
