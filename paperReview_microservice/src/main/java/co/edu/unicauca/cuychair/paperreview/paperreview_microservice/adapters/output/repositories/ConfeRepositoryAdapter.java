package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.repositories;

<<<<<<< HEAD:paperReview_microservice/src/main/java/co/edu/unicauca/cuychair/paperreview/paperreview_microservice/adapters/output/repositories/ConfeRepositoryAdapter.java
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.ConferenceEntity;
=======
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entitis.ConferenceEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.mapper.ConfeRepositoryMaper;
>>>>>>> ec9fe43d46420ac8ba920c26f3e74b6feda685c6:paperReview_microservice/src/main/java/co/edu/unicauca/cuychair/paperreview/paperreview_microservice/adapters/output/repositoris/ConfeRepositoryAdapter.java
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.ConferenceRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfeRepositoryAdapter implements ConferenceRepositoryPort {
    private List<ConferenceEntity> conferences;
    private  ConfeRepositoryMaper maper;


    @Override
    public Conference addConference(Conference conference) {
        if(conferences == null){
            this.conferences = new ArrayList<>();
            maper = new ConfeRepositoryMaper();
        }
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
        int index=conferences.indexOf(maper.toConferenceEntity(conference));
        if(index == -1){
            return null;
        }
        conferences.set(index,maper.toConferenceEntity(conference));
        return conference;
    }

    @Override
    public Conference findById(int id) {
        for(ConferenceEntity conference : conferences){
            if(conference.getId() == id){
                return maper.toConference(conference);
            }
        }
        return null;
    }

    @Override
    public Conference findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
