package co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import co.edu.unicauca.cuychair.user.user_microservice.dataAccess.repository.IUserRepository;
import co.edu.unicauca.cuychair.user.user_microservice.domain.UserEntity;
import co.edu.unicauca.cuychair.user.user_microservice.rabbit.publisher.Publisher;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.ConversorUserDTO;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.LoginDTO;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.UserDTO;

@Slf4j
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    private ConversorUserDTO conversorUserDTO;

    //Metodo para enviar usuarios a rabiitMQ
	@Autowired
	private Publisher publisher;

	//Envia un usuario especificado por la id a rabbit
	public UserDTO sendUserToRabbit(int id) {	
        UserDTO userDTO=getUser(id);//Encuentra un usuario con id especificada
		log.info("Message '{}'  Name of user: '{}' will be send with id '{}' ... ", userDTO,userDTO.getName(),userDTO.getId());
		this.publisher.sendUserDTO(userDTO);//Envia usuario a rabbit
        return userDTO;
	}

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
        this.conversorUserDTO = new ConversorUserDTO();
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        UserEntity userEntity = conversorUserDTO.converseDTOInUser(userDTO);
        userDTO = conversorUserDTO.converseUserInDTO(userRepository.addUser(userEntity)); 
        this.sendUserToRabbit(userDTO.getId());
        return userDTO;
    }

    @Override
    public List<UserDTO> listUsers() {
        List<UserDTO> userDTOList = conversorUserDTO.converseListInDTO(userRepository.listUsers());
        return userDTOList; 
    }

    @Override
    public UserDTO getUser(int id) {
        UserDTO userDTO = conversorUserDTO.converseUserInDTO(userRepository.getUser(userRepository.getIdx(id)));
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

    public UserDTO login(LoginDTO loginDTO){
        UserDTO userDTO = conversorUserDTO.converseUserInDTO(userRepository.login(loginDTO));
        return userDTO;
    }
}
