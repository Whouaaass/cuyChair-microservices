package co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.domain.User;

public interface IRepositoryUser {

    public boolean addUser(User objUser);

    public User getUserById(int id);
}
