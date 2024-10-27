package co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;

public interface IRepositoryConference {

    public boolean addConference(Conference objConference);

    public Conference getConferenceById(int id);
}
