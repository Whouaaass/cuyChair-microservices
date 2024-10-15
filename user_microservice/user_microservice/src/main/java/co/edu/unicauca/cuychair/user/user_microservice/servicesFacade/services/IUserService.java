package co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.services;

import java.util.List;

public interface IUserService {
/**
     * @brief Registra un usuario al final del repositorio
     * @param userDTO usuario a registrar
     * @return El usuario entidad registrado
     */
    public UserDTO addUser(UserDTO userDTO);
    /**
     * @brief Lista todos los usuarios registrados en el repositorio
     * @return Lista de los usuarios registrados
     */
    public List<UserDTO> listUsers();
    /**
     * @brief Retorna el usuario consultado según el id 
     * @param id id del usuario 
     * @return El usuario consultado
     */
    public UserDTO getUser(int id);
    /**
     * @brief Obtiene un usuario segun el email
     * @param email email del usuario
     * @return El usuario consultado
     */
    public UserDTO getUserByEmail(String email);
    /**
     * @brief Actualiza un usuario con los datos del nuevo usuario
     * @param id id del usuario a actualizar
     * @param userDTO nuevo usuario
     * @return Usuario a actualizar
     */
    public UserDTO updateUser(int id, UserDTO userDTO);
    /**
     * @brief Elimina el usuario indicado por el id
     * @param id id del usuario a eliminar
     * @return
     */
    public UserDTO deleteUser(int id);
    /**
     * @brief Verifica si el usuario existe
     * @param id id del usuario preguntado
     * @return si el usuario existe
     */
    public boolean userExist(int id);
}
