package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.cuychair.conference_microservice.data_access.ConferenceRepository;
import co.edu.unicauca.cuychair.conference_microservice.data_access.UserRepository;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.Conference;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.User;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.UserDTO;

/**
 * Implementación de los servicios de usuario
 * @author Frdy
 */
@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final ConferenceRepository conferenceRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository repository, ConferenceRepository conferenceRepo, ModelMapper modelMapper) {
        this.userRepository = repository;
        this.conferenceRepository = conferenceRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = this.userRepository.getAllUsers();
        return this.modelMapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
    }

    @Override
    public UserDTO findById(Integer id) {
        User user = this.userRepository.getUserById(id);
        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO save(UserDTO user) {
        User userEntity = this.modelMapper.map(user, User.class);
        User userSaved = this.userRepository.addUser(userEntity);
        return this.modelMapper.map(userSaved, UserDTO.class);
    }

    @Override
    public UserDTO update(Integer id, UserDTO user) {
        User userEntity = this.modelMapper.map(user, User.class);
        User userUpdated = this.userRepository.updateUser(id, userEntity);
        return this.modelMapper.map(userUpdated, UserDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        return this.userRepository.deleteUser(id) != null;
    }
}
