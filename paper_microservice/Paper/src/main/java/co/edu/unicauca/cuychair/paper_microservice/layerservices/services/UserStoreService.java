package co.edu.unicauca.cuychair.paper_microservice.layerservices.services;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryUser;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper.ConversorUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStoreService {

    IRepositoryUser repositoryUser;

    @Autowired
    public UserStoreService(IRepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public boolean addUser(UserDTO user) {
        ConversorUserDTO map=new ConversorUserDTO();
        return repositoryUser.addUser(map.DTOinUser(user));
    }

    public User getUserById(int id) {
        return repositoryUser.getUserById(id);
    }
}
