package co.edu.unicauca.cuychair.user.user_microservice.domain;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceEntity {
    public ConferenceEntity(){};
    private int id;
    private String title;
    private String city;
    private String date;
    private ArrayList<UserEntity> participantsList;
    private UserEntity owner;
}
