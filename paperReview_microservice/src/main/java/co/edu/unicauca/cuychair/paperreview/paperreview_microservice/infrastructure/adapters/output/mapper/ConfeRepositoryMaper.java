package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Conference;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.ConferenceEntity;

public class ConfeRepositoryMaper {


    public Conference toConference(ConferenceEntity conference) {
        return new Conference(conference.getId(), conference.getTitle(), conference.getCity(), conference.getDate(),conference.getReviewers(),conference.getAuthors(),conference.getOwner());
    }

    public ConferenceEntity toConferenceEntity(Conference conference) {

        return new ConferenceEntity(conference.getId(), conference.getTitle(), conference.getCity(), conference.getDate(),conference.getReviewers(),conference.getAuthors(),conference.getOwner());
    }
}
