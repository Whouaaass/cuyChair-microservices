package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.maper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Conference;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.dto.ConferenceDTO;

public class ConferenceDTOMaper {
    private UserDTOMaper userDTO;


    public ConferenceDTOMaper() {
    }

    public ConferenceDTO ConferenceinDTO(Conference conference){
        return new ConferenceDTO(conference.getId(), conference.getTitle(), conference.getCity(), conference.getDate(),userDTO.toUserDTOList(conference.getReviewers()),userDTO.toUserDTOList(conference.getAuthors()),userDTO.toUserDTO(conference.getOwner()));
    }

    public Conference DTOinConference(ConferenceDTO conferenceDTO){
        return new Conference(conferenceDTO.getId(), conferenceDTO.getTitle(), conferenceDTO.getCity(), conferenceDTO.getDate(),userDTO.toUserList(conferenceDTO.getReviewers()),userDTO.toUserList(conferenceDTO.getAuthors()),userDTO.toUser(conferenceDTO.getOwner()));
    }
}
