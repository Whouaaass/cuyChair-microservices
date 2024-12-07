package co.edu.unicauca.cuychair.paper_microservice.controller.mapper;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.ConferenceDTO;

public class ConversorConferenceDTO {

    private ConversorUserDTO userDTO;


    public ConversorConferenceDTO() {
        userDTO = new ConversorUserDTO();
    }

    public ConferenceDTO toConferenceDTO(Conference conference){
        return new ConferenceDTO(conference.getId(), conference.getTitle(), conference.getCity(), conference.getDate(),userDTO.toUserDTOList(conference.getReviewers()),userDTO.toUserDTOList(conference.getAuthors()),userDTO.toUserDTO(conference.getOwner()));
    }

    public Conference toConference(ConferenceDTO conferenceDTO){
        return new Conference(conferenceDTO.getId(), conferenceDTO.getTitle(), conferenceDTO.getCity(), conferenceDTO.getDate(),userDTO.toUserList(conferenceDTO.getReviewers()),userDTO.toUserList(conferenceDTO.getAuthors()),userDTO.toUser(conferenceDTO.getOwner()));
    }
}
