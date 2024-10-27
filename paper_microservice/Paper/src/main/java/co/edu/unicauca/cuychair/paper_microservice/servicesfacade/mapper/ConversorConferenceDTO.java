package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.ConferenceDTO;

public class ConversorConferenceDTO {


    public ConversorConferenceDTO() {
    }

    public ConferenceDTO ConferenceinDTO(Conference conference){
        return new ConferenceDTO(conference.getId(), conference.getTitle(), conference.getSubject(), conference.getDescription());
    }

    public Conference DTOinConference(ConferenceDTO conferenceDTO){
        return new Conference(conferenceDTO.getId(), conferenceDTO.getName(), conferenceDTO.getSubject(), conferenceDTO.getDescription());
    }
}
