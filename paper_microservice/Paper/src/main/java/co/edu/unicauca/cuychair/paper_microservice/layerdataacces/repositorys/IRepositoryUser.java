package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;

public interface IRepositoryUser {

    public boolean addUser(User objUser);

    public User getUserById(int id);
}
