package co.edu.unicauca.cuychair.paper_microservice.controller.mapper;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ConversorConferenceDTO {

    private ConversorUserDTO userDTO;


    public ConversorConferenceDTO() {
        userDTO = new ConversorUserDTO();
    }

    public ConferenceDTO toConferenceDTO(Conference conference){
        ArrayList<Integer> authors=new ArrayList<>();
        ArrayList<Integer> reviewers=new ArrayList<>();
        for(User u:conference.getAuthors()){
            authors.add(u.getId());
        }
        for(User u:conference.getReviewers()){
            reviewers.add(u.getId());
        }
        return new ConferenceDTO(conference.getId(), conference.getTitle(), conference.getCity(), conference.getDate(), authors,reviewers,conference.getOwner().getId());
    }

    public Conference toConference(ConferenceDTO conferenceDTO,ArrayList<User> users,ArrayList<User> reviewers,User owner){
        return new Conference(conferenceDTO.getId(), conferenceDTO.getTitle(), conferenceDTO.getCity(), conferenceDTO.getDate(),reviewers,users,owner);
    }
}
