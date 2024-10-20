package co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.cuychair.user.user_microservice.domain.UserEntity;

public class ConversorUserDTO {
    @Autowired
    private ModelMapper modelMapper;
    public ConversorUserDTO(){
        this.modelMapper = new ModelMapper();
    }

    public UserDTO converseUserInDTO(UserEntity userEntity){
        UserDTO UserDTO = modelMapper.map(userEntity, UserDTO.class);
        return UserDTO;
    }

    public UserEntity converseDTOInUser(UserDTO UserDTO){
        UserEntity UserEntity = modelMapper.map(UserDTO, UserEntity.class);
        return UserEntity;
    }

    public List<UserDTO> converseListInDTO(List<UserEntity> userList){
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }
}
