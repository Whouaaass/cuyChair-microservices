package co.edu.unicauca.cuychair.paper_microservice.layerservices.services;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStoreService {

    IRepositoryUser repositoryUser;

    @Autowired
    public UserStoreService(IRepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public void addUser(User user) {
        repositoryUser.addUser(user);
    }

    public User getUserById(Long id) {
        return repositoryUser.getUserById(id);
    }
}
