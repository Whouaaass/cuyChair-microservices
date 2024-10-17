package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;

public interface IRepositoryConference {

    public boolean addConference(Conference objConference);

    public Conference getConferenceById(int id);
}
