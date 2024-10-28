/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.services;

import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

import co.edu.unicauca.cuychair.gui.gui.DTO.conferenceAPI.AddConferenceParticipationDTO;
import co.edu.unicauca.cuychair.gui.gui.DTO.conferenceAPI.ConferenceDTO;
import co.edu.unicauca.cuychair.gui.gui.DTO.conferenceAPI.PostConferenceDTO;

/**
 *
 * @author julia
 * @author Frdy
 */
public class ConferenceServices {
    private static final String ENDPOINT = "http://localhost:8092/api";
    private final Client client;
    
    public ConferenceServices(){        
        client = ClientBuilder.newClient().register(new JacksonFeature());
    }
    // Revisar si el path es correcto
    public List<ConferenceDTO> getAllConferences() {
        WebTarget target = client.target(ENDPOINT+"/conference");
        return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<ConferenceDTO>>() {});
    }
    
    // Revisar si el path es correcto
    public ConferenceDTO addConference(String city, String title, String subject, Date date, String description, Integer ownerId) {
        PostConferenceDTO post = new PostConferenceDTO();
        post.setCity(city);
        post.setTitle(title);
        post.setDate(date);
        post.setOwnerId(ownerId);        
        post.setDescription(description);
        post.setSubject(subject);
        WebTarget target = client.target(ENDPOINT + "/conference");
        return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(post, MediaType.APPLICATION_JSON), ConferenceDTO.class);
    }

    public ConferenceDTO getConference(Integer conferenceId) {
        WebTarget target = client.target(ENDPOINT + "/conference/" + conferenceId);
        return target.request(MediaType.APPLICATION_JSON).get(ConferenceDTO.class);
    }

    public ConferenceDTO addAuthor(Integer conferenceId, Integer authorId) {
        AddConferenceParticipationDTO conferenceParticipation = new AddConferenceParticipationDTO();
        conferenceParticipation.setConferenceId(conferenceId);
        conferenceParticipation.setUserId(authorId);
        WebTarget target = client.target(ENDPOINT + "/addAuthor");
        return target.request(MediaType.APPLICATION_JSON).put(Entity.entity(conferenceParticipation, MediaType.APPLICATION_JSON), ConferenceDTO.class);
    }

    public ConferenceDTO addReviewer(Integer conferenceId, Integer reviewerId) {
        AddConferenceParticipationDTO conferenceParticipation = new AddConferenceParticipationDTO();
        conferenceParticipation.setConferenceId(conferenceId);
        conferenceParticipation.setUserId(reviewerId);
        WebTarget target = client.target(ENDPOINT + "/addReviewer");
        return target.request(MediaType.APPLICATION_JSON).put(Entity.entity(conferenceParticipation, MediaType.APPLICATION_JSON), ConferenceDTO.class);
    }

}
