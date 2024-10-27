/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.cuychair.gui.gui.DTO.UserDTO;
import reactor.core.publisher.Mono;

/**
 *
 * @author julia
 */
public class UserController {
    @Autowired
    private WebClient.Builder webClientBuilder;
    
    //Trae un usuario segun su id
    public UserDTO getUserById(int id) {
        String url = "http://localhost:8091/user_microservice/user/getUser/{id}";

        Mono<UserDTO> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(UserDTO.class);

                return response.block(); 
    }

    //Añadir usuario
    public UserDTO addUser(UserDTO userDTO) {
        String url = "http://localhost:8091/user_microservice/user/addUser";
        
        Mono<UserDTO> response = webClientBuilder.build()
                .post()  // Post service
                .uri(url)
                .body(Mono.just(userDTO), UserDTO.class)  // Agrega el cuerpo de la solicitud
                .retrieve()
                .bodyToMono(UserDTO.class);
        
            return response.block(); 
    }
}
