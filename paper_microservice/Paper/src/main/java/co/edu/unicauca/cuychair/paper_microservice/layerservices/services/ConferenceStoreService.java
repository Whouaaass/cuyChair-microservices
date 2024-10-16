package co.edu.unicauca.cuychair.paper_microservice.layerservices.services;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryConference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceStoreService {

    IRepositoryConference repositoryConference;

    @Autowired
    public ConferenceStoreService(IRepositoryConference repositoryConference) {
        this.repositoryConference = repositoryConference;
    }

    public void addConference(Conference conference) {
        repositoryConference.addConference(conference);
    }

    public Conference getConferenceById(Long id) {
        return repositoryConference.getConferenceById(id);
    }
}
