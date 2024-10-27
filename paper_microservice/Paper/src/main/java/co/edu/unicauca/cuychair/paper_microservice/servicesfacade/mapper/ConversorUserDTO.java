package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper;

import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.UserDTO;

public class ConversorUserDTO {

    public ConversorUserDTO() {

    }

    public UserDTO UserinDTO(User user){
        return new UserDTO(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getDescription(), user.getPhone());
    }

    public User DTOinUser(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getDescription(), userDTO.getPhone());
    }
}
