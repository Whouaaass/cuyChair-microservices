package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;

import java.util.List;

import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.UserDTO;

/**
 * Interface del servicio de usuarios
 * @author Frdy
 */
public interface  IUserService {

    /**
     * Buscar todos los usuarios
     * @return
     */
    public List<UserDTO> findAll();

    /**
     * Buscar un usuario por su id
     * @param id
     * @return
     */
    public UserDTO findById(Integer id);

    /**
     * Guardar un usuario
     * @param user
     * @return
     */
    public UserDTO save(UserDTO user);

    /**
     * Actualizar un usuario
     * @param id
     * @param user
     * @return
     */
    public UserDTO update(Integer id, UserDTO user);

    /**
     * Listar usuarios por rol en una conferencia
     * @param id
     * @return
     */
    public List<UserDTO> findByRoleInConference(Integer id, String role);

    /**
     * Eliminar un usuario
     * @param id
     * @return
     */
    public boolean delete(Integer id);    

}
