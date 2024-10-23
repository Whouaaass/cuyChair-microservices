package co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.UserDTO;
import org.modelmapper.ModelMapper;

public class ConversorConferenceDTO {


    public ConversorConferenceDTO() {
    }

    public ConferenceDTO ConferenceinDTO(Conference conference){
        return new ConferenceDTO(conference.getId(), conference.getTitle(), conference.getDescription(), conference.getCity());
    }

    public Conference DTOinConference(ConferenceDTO conferenceDTO){
        return new Conference(conferenceDTO.getId(), conferenceDTO.getTitle(), conferenceDTO.getDescription(), conferenceDTO.getCity());
    }
}
