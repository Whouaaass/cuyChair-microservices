package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Conference;

public interface ConferenceRepositoryPort {
    Conference addConference(Conference conference);
    Conference removeConference(Conference conference);
    Conference updateConference(Conference conference);
    Conference findById(int id);
}
