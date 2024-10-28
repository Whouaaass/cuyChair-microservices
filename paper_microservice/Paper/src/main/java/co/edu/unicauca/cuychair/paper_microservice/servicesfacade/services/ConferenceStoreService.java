package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper.ConversorConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper.ConversorUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceStoreService {

    private final IRepositoryConference repositoryConference;


    public ConferenceStoreService(IRepositoryConference repositoryConference) {
        this.repositoryConference = repositoryConference;
    }

    public boolean addConference(ConferenceDTO conference) {
        ConversorConferenceDTO map=new ConversorConferenceDTO();
        return repositoryConference.addConference(map.DTOinConference(conference));
    }

    public Conference getConferenceById(int id) {
        return repositoryConference.getConferenceById(id);
    }

    public List<Integer> conferencesParticipanUser(UserDTO author) {
        ConversorUserDTO map=new ConversorUserDTO();
        return repositoryConference.conferenceParticipanByAuthor(map.DTOinUser(author));
    }
}
