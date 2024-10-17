package co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.UserDTO;
import org.modelmapper.ModelMapper;

public class ConversorConferenceDTO {
    private ModelMapper modelMapper;

    public ConversorConferenceDTO() {
        this.modelMapper = new ModelMapper();
    }

    public ConferenceDTO ConferenceinDTO(Conference conference){
        return modelMapper.map(conference, ConferenceDTO.class);
    }

    public Conference DTOinConference(ConferenceDTO conferenceDTO){
        return modelMapper.map(conferenceDTO, Conference.class);
    }
}
