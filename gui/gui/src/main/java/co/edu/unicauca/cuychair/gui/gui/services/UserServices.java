/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

import co.edu.unicauca.cuychair.gui.gui.DTO.UserDTO;

public class UserServices {
    private String endPoint;
    private Client client;

    public UserServices() {
        this.endPoint = "http://localhost:8091/user_microservice/User";
        this.client = ClientBuilder.newClient().register(new JacksonFeature());
    }

    // Método para obtener un usuario por ID
    public UserDTO getUserById(int id) {
        WebTarget target = client.target(endPoint + "/getUser/" + id);
        return target.request(MediaType.APPLICATION_JSON).get(new GenericType<UserDTO>() {});
    }

    // Método para agregar un usuario
    public UserDTO addUser(UserDTO userDTO) {
        WebTarget target = client.target(endPoint + "/addUser");
        return target.request(MediaType.APPLICATION_JSON)
                     .post(Entity.entity(userDTO, MediaType.APPLICATION_JSON), UserDTO.class);
    }
}

