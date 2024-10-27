package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper;

import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class ConversorUserDTO {

    public ConversorUserDTO() {

    }

    public UserDTO UserinDTO(User user){
        return new UserDTO(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getDescription(), user.getPhone());
    }

    public User DTOinUser(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getDescription(), userDTO.getPhone());
    }

    public ArrayList<User> DTOinUsers(List<UserDTO> userDTOs){
        ArrayList<User> users = new ArrayList<User>();
        for(UserDTO userDTO : userDTOs){
            users.add(DTOinUser(userDTO));
        }
        return users;
    }

    public ArrayList<UserDTO> UsersinDTO(List<User> userDTOs){
        ArrayList<UserDTO> users = new ArrayList<UserDTO>();
        for(User user : userDTOs){
            users.add(UserinDTO(user));
        }
        return users;
    }
}
