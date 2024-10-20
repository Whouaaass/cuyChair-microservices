package co.edu.unicauca.cuychair.user.user_microservice.controllers;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.UserDTO;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user_microservice/user")
public class UserController {
    @Autowired
    UserService userService;
	
    //Test de envío de usuarios a rabbitmq
	@GetMapping("/SendUser/{id}")
	public void SendUser(@PathVariable int id) {
		this.userService.sendUserToRabbit(id);
	}
	
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    
    @GetMapping("/listUsers")
    public List<UserDTO> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/getUser/{id}")
    public UserDTO getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/getUserByEmail")
    public UserDTO getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/updateUser/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public UserDTO deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/userExist/{id}")
    public boolean userExist(@PathVariable int id) {
        return userService.userExist(id);
    }
    
}
