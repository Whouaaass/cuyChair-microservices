package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.maper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.dto.UserDTO;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTOMaper {

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
