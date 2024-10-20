package co.edu.unicauca.cuychair.paper_microservice.layerservices.services;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper.ConversorConferenceDTO;
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
