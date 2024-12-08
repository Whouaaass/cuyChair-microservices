package co.edu.unicauca.cuychair.user.user_microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.UserDTO;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
	
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Envia un usuario a la cola de RabbitMQ
     * @param id
     * @return
     */
    @GetMapping("/SendUser/{id}")
    public UserDTO SendUser(@PathVariable int id) {
        return this.userService.sendUserToRabbit(id);
    }    

    /**
     * Añade un usuario al repositorio
     * @param userDTO
     * @return
     */
    @PostMapping("/addUser")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);//Añado al repo
    }

    /**
     * Lista todos los usuarios
     * @return
     */
    @GetMapping("/listUsers")
    public List<UserDTO> listUsers() {
        return userService.listUsers();
    }

    /**
     * Obtiene un usuario por su id
     * @param id id del usuario
     * @return el usuario
     */
    @GetMapping("/getUser/{id}")
    public UserDTO getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    /**
     * Obtiene un usuario por su email
     * @param email email del usuario
     * @return el usuario
     */
    @GetMapping("/getUserByEmail")
    public UserDTO getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }


    /**
     * Actualiza un usuario
     * @param id
     * @param userDTO
     * @return
     */
    @PutMapping("/updateUser/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    /**
     * Elimina un usuario
     * @param id id del usuario
     * @return el usuario eliminado
     */
    @DeleteMapping("/deleteUser/{id}")
    public UserDTO deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    /**
     * Verifica si un usuario existe
     * @param id
     * @return true si existe, false si no
     */
    @GetMapping("/userExist/{id}")
    public boolean userExist(@PathVariable int id) {
        return userService.userExist(id);
    }
    
}
