package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper.ConversorConferenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceStoreService {

    IRepositoryConference repositoryConference;



    @Autowired
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
}