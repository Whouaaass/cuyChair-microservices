package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorUserDTO;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceStoreService {

    private final IRepositoryConference repositoryConference;


    public ConferenceStoreService(IRepositoryConference repositoryConference) {
        this.repositoryConference = repositoryConference;
    }

    public Conference addConference(Conference conference) {
        return repositoryConference.addConference(conference);
    }

    public Conference getConferenceById(int id) {
        return repositoryConference.getConferenceById(id);
    }

    public List<Integer> conferencesParticipanUser(User author) {
        return repositoryConference.conferenceParticipanByAuthor(author);
    }
}
