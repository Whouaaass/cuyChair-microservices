package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceEntity {
    private int id;
    private String title;
    private String city;
    private Date date;

    private ArrayList<User> reviewers;
    private ArrayList<User> authors;

    private User owner;
}
