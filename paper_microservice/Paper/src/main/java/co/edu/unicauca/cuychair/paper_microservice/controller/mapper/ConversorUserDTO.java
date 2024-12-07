package co.edu.unicauca.cuychair.paper_microservice.controller.mapper;

import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class ConversorUserDTO {

    public ConversorUserDTO() {

    }

    public UserDTO toUserDTO(User user){
        return new UserDTO(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getDescription(), user.getPhone());
    }

    public User toUser(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getDescription(), userDTO.getPhone());
    }

    public ArrayList<User> toUserList(List<UserDTO> userDTOs){
        ArrayList<User> users = new ArrayList<User>();
        for(UserDTO userDTO : userDTOs){
            users.add(toUser(userDTO));
        }
        return users;
    }

    public ArrayList<UserDTO> toUserDTOList(List<User> userDTOs){
        ArrayList<UserDTO> users = new ArrayList<UserDTO>();
        for(User user : userDTOs){
            users.add(toUserDTO(user));
        }
        return users;
    }
}
