package co.edu.unicauca.cuychair.user.user_microservice.dataAccess.domain;
import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceEntity {
    public ConferenceEntity(){};
    private String title;
    private String city;
    private Date date;
    private ArrayList<UserEntity> participantsList;
    private UserEntity owner;
    private int phone;
}
