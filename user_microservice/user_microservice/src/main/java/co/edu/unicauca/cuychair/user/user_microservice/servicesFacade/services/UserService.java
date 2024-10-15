package co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.cuychair.user.user_microservice.dataAccess.domain.UserEntity;
import co.edu.unicauca.cuychair.user.user_microservice.dataAccess.repository.IUserRepository;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.ConversorUserDTO;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.UserDTO;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    private ConversorUserDTO conversorUserDTO;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
        this.conversorUserDTO = new ConversorUserDTO();
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        UserEntity userEntity = conversorUserDTO.converseDTOInUser(userDTO);
        userDTO = conversorUserDTO.converseUserInDTO(userRepository.addUser(userEntity)); 
        return userDTO;
    }

    @Override
    public List<UserDTO> listUsers() {
        List<UserDTO> userDTOList = conversorUserDTO.converseListInDTO(userRepository.listUsers());
        return userDTOList; 
    }

    @Override
    public UserDTO getUser(int id) {
        UserDTO userDTO = conversorUserDTO.converseUserInDTO(userRepository.getUser(id));
        return userDTO;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserDTO userDTO = conversorUserDTO.converseUserInDTO(userRepository.getUserByEmail(email));
        return userDTO;
    }

    @Override
    public UserDTO updateUser(int id, UserDTO userDTO) {
        UserEntity userEntity = conversorUserDTO.converseDTOInUser(userDTO);
        userDTO = conversorUserDTO.converseUserInDTO(userRepository.updateUser(id, userEntity));
        return userDTO;
    }

    @Override
    public UserDTO deleteUser(int id) {
        UserDTO userDTO = conversorUserDTO.converseUserInDTO(userRepository.deleteUser(id));
        return userDTO;
    }

    @Override
    public boolean userExist(int id) {
        return userRepository.userExist(id);
    }

}
