/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.services;

import co.edu.unicauca.cuychair.gui.gui.DTO.ConferenceDTO;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author julia
 */
public class ConferenceServices {
    private String endPoint;
    private Client client;
    
    public ConferenceServices(){
        this.endPoint="http://localhost:8092/conference_microservice/Conferences";
        client = ClientBuilder.newClient().register(new JacksonFeature());
    }
    // Revisar si el path es correcto
    public List<ConferenceDTO> getAllConferences() {
        WebTarget target = client.target(endPoint+"/getAllConferences");
        return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<ConferenceDTO>>() {});
    }
    
    // Revisar si el path es correcto
    public ConferenceDTO addConference(ConferenceDTO conferenceDTO) {
        WebTarget target = client.target(endPoint + "/addConference");
        return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(conferenceDTO, MediaType.APPLICATION_JSON), ConferenceDTO.class);
    }
}
