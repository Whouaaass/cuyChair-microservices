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
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import co.edu.unicauca.cuychair.gui.gui.DTO.UserDTO;

public class UserServices {
    private String endPoint;
    private Client client;

    public UserServices() {
        this.endPoint = "http://localhost:8091/user_microservice/user";
        this.client = ClientBuilder.newClient().register(new JacksonFeature());
    }

    // Método para obtener un usuario por ID
    public UserDTO getUserById(int id) {
        WebTarget target = client.target(endPoint + "/getUser/" + id);
        return target.request(MediaType.APPLICATION_JSON).get(new GenericType<UserDTO>() {});
    }
    // Método para obtener un usuario por Email
    public UserDTO getUserByEmail(String email) {
        try {
            WebTarget target = client.target(endPoint + "/getUserByEmail?email=" + email);
            return target.request(MediaType.APPLICATION_JSON).get(new GenericType<UserDTO>() {});
        } catch (Exception e) {
            System.out.println("Error en la solicitud: " + e.getMessage());
        }
        return null;
    }
    
    //Metodo para hacer set de un usuario
    public UserDTO updateUser(int id, UserDTO userDTO) {
        WebTarget target = client.target(endPoint + "/updateUser/" + id);
        return target.request(MediaType.APPLICATION_JSON).method("PUT", Entity.
                entity(userDTO, MediaType.APPLICATION_JSON), UserDTO.class);
    }

    // Método para agregar un usuario
    public UserDTO addUser(UserDTO userDTO) {
    WebTarget target = client.target(endPoint + "/addUser");
    try {
        // Hacer la solicitud POST y obtener la respuesta
        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(userDTO, MediaType.APPLICATION_JSON));
        // Comprobar el estado HTTP de la respuesta
        if (response.getStatus() == Response.Status.OK.getStatusCode() || 
            response.getStatus() == Response.Status.CREATED.getStatusCode()) {
            return response.readEntity(UserDTO.class); // Leer y devolver el usuario
        } else {
            System.err.println("Error en la solicitud. Código de estado: " + response.getStatus());
            System.err.println("Mensaje de error: " + response.readEntity(String.class));
            return null;
        }
    } catch (Exception e) {
        System.err.println("Excepción al agregar usuario: " + e.getMessage());
        e.printStackTrace();
        return null;
    }
    }
}

