package co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RepositoryConference implements IRepositoryConference{

    private ArrayList<Conference> listConference;

    public RepositoryConference() {
        this.listConference=new ArrayList<>();
    }

    @Override
    public boolean addConference(Conference objConference) {
        int index=listConference.indexOf(objConference);
        if(index<0){
            return listConference.add(objConference);
        }
        listConference.set(index, objConference);
        return true;
    }

    @Override
    public Conference getConferenceById(int id) {
        for(Conference conf:listConference){
            if(Objects.equals(conf.getId(), id)){
                return conf;
            }
        }
        return null;
    }

    @Override
    public List<Integer> conferenceParticipanByAuthor(User author) {
        List<Integer> listConferences=new ArrayList<>();
        for(Conference conference:listConference){
            if(conference.getAuthors().contains(author)){
            listConferences.add(conference.getId());
            }
        }
        return listConferences;
    }
}
