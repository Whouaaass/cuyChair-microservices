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
    public Conference addConference(Conference objConference) {
        int index=listConference.indexOf(objConference);
        if(index!=-1){
            if(isEquals(objConference,listConference.get(index))){
                listConference.remove(index);
                return objConference;
            }
            listConference.set(index, objConference);
            return objConference;
        }
        listConference.add(objConference);
        return objConference;
    }

    private boolean isEquals(Conference objConference1, Conference objConference2) {
        return objConference1.getTitle().equals(objConference2.getTitle()) && objConference1.getDate().equals(objConference2.getDate())
                && objConference1.getReviewers().size() == objConference2.getReviewers().size()
                && objConference1.getAuthors().size() == objConference2.getAuthors().size();
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
