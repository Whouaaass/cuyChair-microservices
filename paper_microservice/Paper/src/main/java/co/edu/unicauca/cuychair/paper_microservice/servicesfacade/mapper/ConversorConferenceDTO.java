package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.ConferenceDTO;

public class ConversorConferenceDTO {

    private ConversorUserDTO userDTO;


    public ConversorConferenceDTO() {
    }

    public ConferenceDTO ConferenceinDTO(Conference conference){
        return new ConferenceDTO(conference.getId(), conference.getTitle(), conference.getCity(), conference.getDate(),userDTO.UsersinDTO(conference.getReviewers()),userDTO.UsersinDTO(conference.getAuthors()),userDTO.UserinDTO(conference.getOwner()));
    }

    public Conference DTOinConference(ConferenceDTO conferenceDTO){
        return new Conference(conferenceDTO.getId(), conferenceDTO.getTitle(), conferenceDTO.getCity(), conferenceDTO.getDate(),userDTO.DTOinUsers(conferenceDTO.getReviewers()),userDTO.DTOinUsers(conferenceDTO.getAuthors()),userDTO.DTOinUser(conferenceDTO.getOwner()));
    }
}
