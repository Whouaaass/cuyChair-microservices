package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.services;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input.ServiceConferencePort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.ConferenceRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ConferenceServices implements ServiceConferencePort {

    private ConferenceRepositoryPort repository;

    @Override
    public Conference addConference(Conference conference) {
        return repository.addConference(conference);
    }

    @Override
    public Conference removeConference(Conference conference) {
        return repository.removeConference(conference);
    }

    @Override
    public Conference updateConference(Conference conference) {
        return repository.updateConference(conference);
    }

    @Override
    public Conference findById(int id) {
        return repository.findById(id);
    }
}
