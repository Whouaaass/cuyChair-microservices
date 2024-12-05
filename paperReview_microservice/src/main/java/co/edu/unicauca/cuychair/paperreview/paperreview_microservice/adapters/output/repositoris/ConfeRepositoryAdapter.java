package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.repositoris;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entitis.ConferenceEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.ConferenceRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConfeRepositoryAdapter implements ConferenceRepositoryPort {
    private List<ConferenceEntity> conferences;

    @Override
    public Conference addConference(Conference conference) {
        return null;
    }

    @Override
    public Conference removeConference(Conference conference) {
        return null;
    }

    @Override
    public Conference updateConference(Conference conference) {
        return null;
    }
}
