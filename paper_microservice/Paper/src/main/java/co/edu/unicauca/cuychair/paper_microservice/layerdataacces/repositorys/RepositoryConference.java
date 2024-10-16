package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;
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
    public void addConference(Conference objConference) {
        listConference.add(objConference);
    }

    @Override
    public Conference getConferenceById(Long id) {
        for(Conference conf:listConference){
            if(Objects.equals(conf.getId(), id)){
                return conf;
            }
        }
        return null;
    }
}
