package co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;

import java.util.List;

public interface IRepositoryConference {

    public boolean addConference(Conference objConference);

    public Conference getConferenceById(int id);

    public List<Integer> conferenceParticipanByAuthor(User author);
}
