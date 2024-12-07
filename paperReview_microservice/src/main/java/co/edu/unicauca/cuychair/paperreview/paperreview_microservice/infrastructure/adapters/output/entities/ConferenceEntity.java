package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.User;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConferenceEntity) {
            ConferenceEntity other = (ConferenceEntity) obj;
            return this.id ==other.getId();
        }
        return super.equals(obj);
    }
}
