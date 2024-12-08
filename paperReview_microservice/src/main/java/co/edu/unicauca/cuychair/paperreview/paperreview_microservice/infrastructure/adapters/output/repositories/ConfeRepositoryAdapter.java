package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.repositories;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.ConferenceRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Conference;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.ConferenceEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper.ConfeRepositoryMaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfeRepositoryAdapter implements ConferenceRepositoryPort {
    private List<ConferenceEntity> conferences = new ArrayList<>();;
    private ConfeRepositoryMaper maper = new ConfeRepositoryMaper();;

    @Override
    public Conference addConference(Conference conference) {
        conferences.add(maper.toConferenceEntity(conference));
        return conference;
    }

    @Override
    public Conference removeConference(Conference conference) {
        conferences.remove(maper.toConferenceEntity(conference));
        return conference;
    }

    @Override
    public Conference updateConference(Conference conference) {
        int index = conferences.indexOf(maper.toConferenceEntity(conference));
        if (index == -1) {
            return null;
        }
        conferences.set(index, maper.toConferenceEntity(conference));
        return conference;
    }

    @Override
    public Conference findById(int id) {
        for (ConferenceEntity conference : conferences) {
            if (conference.getId() == id) {
                return maper.toConference(conference);
            }
        }
        return null;
    }

}
