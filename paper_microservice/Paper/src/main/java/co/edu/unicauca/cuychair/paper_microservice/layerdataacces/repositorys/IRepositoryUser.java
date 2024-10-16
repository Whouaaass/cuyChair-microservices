package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;

public interface IRepositoryUser {

    public void addUser(User objUser);

    public User getUserById(Long id);
}
