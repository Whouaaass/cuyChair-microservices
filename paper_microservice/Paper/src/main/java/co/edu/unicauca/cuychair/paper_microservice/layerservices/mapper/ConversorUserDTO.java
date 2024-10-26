package co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ConversorUserDTO {

    public ConversorUserDTO() {

    }

    public UserDTO UserinDTO(User user){
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public User DTOinUser(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
