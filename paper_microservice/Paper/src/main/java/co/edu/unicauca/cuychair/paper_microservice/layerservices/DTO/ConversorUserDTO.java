package co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

public class ConversorUserDTO {
    @Autowired
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
