package co.edu.unicauca.cuychair.gui.api.services;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;

import org.glassfish.jersey.jackson.JacksonFeature;

import co.edu.unicauca.cuychair.gui.api.dtos.paperAPI.PaperDTO;
import co.edu.unicauca.cuychair.gui.api.dtos.paperAPI.UserDTO;

/**
 *
 * @author julia
 */
public class PaperServices {

    private String endPoint;
    private Client client;

    public PaperServices() {
        this.endPoint = "http://localhost:8094/api";
        this.client = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public PaperDTO addPaper(PaperDTO paper) {
        WebTarget target = client.target(endPoint + "/paper");
        try{
            Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(paper, MediaType.APPLICATION_JSON));
            if (response.getStatus() == Response.Status.OK.getStatusCode() ||
                    response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                return response.readEntity(PaperDTO.class); // Leer y devolver el usuario
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

    public PaperDTO editPaper(PaperDTO paper) {
        WebTarget target = client.target(endPoint + "/edit");
        return target.request(MediaType.APPLICATION_JSON).method("POST", Entity.
                entity(paper, MediaType.APPLICATION_JSON), PaperDTO.class);
    }

    public PaperDTO deletePaper(PaperDTO paper) {
        WebTarget target = client.target(endPoint );
        return target.request(MediaType.APPLICATION_JSON).method("DELETE", Entity.
                entity(paper, MediaType.APPLICATION_JSON), PaperDTO.class);
    }

    public List<PaperDTO> getPapersByAuthor(int authorId) {
        WebTarget target = client.target(endPoint + "/paperAuthor/"+authorId);
        return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<PaperDTO>>() {});
    }

    public List<Integer> conferencesByAuthor(UserDTO author) {
        WebTarget target = client.target(endPoint + "/listconferences/"+author.getId());
        return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Integer>>() {});
    }
}
