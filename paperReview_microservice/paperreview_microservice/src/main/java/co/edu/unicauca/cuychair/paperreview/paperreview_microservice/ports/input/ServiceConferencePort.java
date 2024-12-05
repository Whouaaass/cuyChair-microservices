package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Conference;

public interface ServiceConferencePort {
    Conference addConference(Conference conference);
    Conference removeConference(Conference conference);
    Conference updateConference(Conference conference);
    Conference findById(int id);
}
