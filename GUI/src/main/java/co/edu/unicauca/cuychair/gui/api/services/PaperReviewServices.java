package co.edu.unicauca.cuychair.gui.api.services;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI.PaperReviewDTO;
import co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI.PaperReviewItemDTO;
import co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI.PaperReviewResDTO;
import co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI.ResultChangeStateDTO;

public class PaperReviewServices {
    private static final String ENDPOINT = "http://localhost:8093/paperReview";
    private final Client client;


    public final static String DRAFT_STATE = "DRAFT";
    public final static String PUBLISHED_STATE = "PUBLISHED";
    public final static String REJECTED_STATE = "REJECTED";
    public final static String MODERATION_STATE = "MODERATION";

    // Constructor
    public PaperReviewServices() {
        this.client = ClientBuilder.newClient().register(JacksonFeature.class);
    }

    // Método para obtener un PaperReview por ID
    public PaperReviewResDTO getPaperReview(int paperReviewId) {
        WebTarget target = client.target(ENDPOINT + "/get/" + paperReviewId);
        return target.request(MediaType.APPLICATION_JSON).get(PaperReviewResDTO.class);
    }

    // Método para obtener un PaperReview por paperId
    public PaperReviewDTO getPaperReviewByPaper(int paperId) {
        WebTarget target = client.target(ENDPOINT + "/getByPaper/" + paperId);
        return target.request(MediaType.APPLICATION_JSON).get(PaperReviewDTO.class);
    }

    public List<PaperReviewItemDTO> getPendingReviews(int conferenceId) {
        WebTarget target = client.target(ENDPOINT + "/listByConference/" + conferenceId);
        return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<PaperReviewItemDTO>>() {});
    }


    // Método para cambiar el estado de un PaperReview
    public ResultChangeStateDTO changeState(int paperReviewId, int reviewerId, String newState) {
        WebTarget target = client.target(ENDPOINT + "/changeState/" + paperReviewId + "/" + reviewerId + "/" + newState);
        Response response = target.request(MediaType.APPLICATION_JSON).put(Entity.entity("", MediaType.APPLICATION_JSON));
        return response.readEntity(ResultChangeStateDTO.class);
    }

}
