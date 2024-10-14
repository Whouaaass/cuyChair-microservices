package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.cuychair.conference_microservice.data_access.UserRepository;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.User;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.UserDTO;

/**
 * Implementación de los servicios de usuario
 * @author Frdy
 */
@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = this.repository.getAllUsers();
        return this.modelMapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
    }

    @Override
    public UserDTO findById(Integer id) {
        User user = this.repository.getUserById(id);
        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO save(UserDTO user) {
        User userEntity = this.modelMapper.map(user, User.class);
        User userSaved = this.repository.addUser(userEntity);
        return this.modelMapper.map(userSaved, UserDTO.class);
    }

    @Override
    public UserDTO update(Integer id, UserDTO user) {
        User userEntity = this.modelMapper.map(user, User.class);
        User userUpdated = this.repository.updateUser(id, userEntity);
        return this.modelMapper.map(userUpdated, UserDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        return this.repository.deleteUser(id) != null;
    }
}
