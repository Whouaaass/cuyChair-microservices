package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;

public interface IRepositoryConference {

    public void addConference(Conference objConference);

    public Conference getConferenceById(Long id);
}
