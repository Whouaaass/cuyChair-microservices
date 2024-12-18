package co.edu.unicauca.cuychair.user.user_microservice.dataAccess.repository;

import java.util.List;

import co.edu.unicauca.cuychair.user.user_microservice.domain.UserEntity;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.LoginDTO;

public interface IUserRepository {
    /**
     * @brief Registra un usuario al final del repositorio
     * @param user usuario a registrar
     * @return El usuario entidad registrado
     */
    public UserEntity addUser(UserEntity user);
    /**
     * @brief Lista todos los usuarios registrados en el repositorio
     * @return Lista de los usuarios registrados
     */
    public List<UserEntity> listUsers();
    /**
     * @brief Retorna el usuario consultado según el id 
     * @param id id del usuario 
     * @return El usuario consultado
     */
    public UserEntity getUser(int id);
    /**
     * @brief Obtiene un usuario segun el email
     * @param email email del usuario
     * @return El usuario consultado
     */
    public UserEntity getUserByEmail(String email);
    /**
     * @brief Actualiza un usuario con los datos del nuevo usuario
     * @param id id del usuario a actualizar
     * @param user nuevo usuario
     * @return Usuario a actualizar
     */
    public UserEntity updateUser(int id, UserEntity user);
    /**
     * @brief Elimina el usuario indicado por el id
     * @param id id del usuario a eliminar
     * @return
     */
    public UserEntity deleteUser(int id);
    /**
     * @brief Verifica si el usuario existe
     * @param id id del usuario preguntado
     * @return si el usuario existe
     */
    public boolean userExist(int id);
    /**
     * @brief Trae el idx de un usuario
     * @param id id del usuario
     * @return idx en el repositorio del usuario
     */
    public int getIdx(int id);
    /**
     * @brief verifica si un logeo esta bien
     * @param loginDTO
     * @return resultado del logeo
     */
    public UserEntity login(LoginDTO loginDTO);
}
