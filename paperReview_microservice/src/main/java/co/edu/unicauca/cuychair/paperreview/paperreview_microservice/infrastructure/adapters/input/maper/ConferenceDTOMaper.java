package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.maper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Conference;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.User;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.dto.ConferenceDTO;

import java.util.ArrayList;

public class ConferenceDTOMaper {
    private UserDTOMaper userDTO;


    public ConferenceDTOMaper() {
    }

    public ConferenceDTO ConferenceinDTO(Conference conference){
        ArrayList<Integer> authors=new ArrayList<>();
        ArrayList<Integer> reviewers=new ArrayList<>();
        for(User u:conference.getAuthors()){
            authors.add(u.getId());
        }
        for(User u:conference.getReviewers()){
            reviewers.add(u.getId());
        }
        return new ConferenceDTO(conference.getId(), conference.getTitle(), conference.getCity(), conference.getDate(),reviewers,authors,conference.getOwner().getId());
    }

    public Conference DTOinConference(ConferenceDTO conferenceDTO,ArrayList<User> authors,ArrayList<User> reviewers,User owner){
        return new Conference(conferenceDTO.getId(), conferenceDTO.getTitle(), conferenceDTO.getCity(), conferenceDTO.getDate(),reviewers,authors,owner);
    }
}
