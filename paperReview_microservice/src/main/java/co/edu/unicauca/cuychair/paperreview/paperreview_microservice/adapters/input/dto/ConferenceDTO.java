package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class ConferenceDTO {
    private Integer id;
    private String title;
    private String city;
    private Date date;
    private ArrayList<UserDTO> reviewers;
    private ArrayList<UserDTO> authors;
    private UserDTO owner;
}
