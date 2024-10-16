package co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ConversorUserDTO {
    private ModelMapper modelMapper;

    public ConversorUserDTO() {
        this.modelMapper = new ModelMapper();
    }

    public UserDTO UserinDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public User DTOinUser(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
}
