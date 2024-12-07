package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services;

import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryUser;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorUserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserStoreService {

    private final IRepositoryUser repositoryUser;


    public UserStoreService(IRepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public User addUser(User user) {
        return repositoryUser.addUser(user);
    }

    public User getUserById(int id) {
        return repositoryUser.getUserById(id);
    }
}
