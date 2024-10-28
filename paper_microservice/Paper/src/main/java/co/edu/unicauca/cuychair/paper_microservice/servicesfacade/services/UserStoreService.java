package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services;

import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryUser;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper.ConversorUserDTO;
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

    public UserDTO getUserById(int id) {
        ConversorUserDTO map=new ConversorUserDTO();
        return map.UserinDTO(repositoryUser.getUserById(id));
    }
}
