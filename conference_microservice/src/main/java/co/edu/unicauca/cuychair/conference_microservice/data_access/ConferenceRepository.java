package co.edu.unicauca.cuychair.conference_microservice.data_access;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.Conference;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.User;

/**
 * Repositorio de conferencias
 */
@Repository
public class ConferenceRepository {

    private final ArrayList<Conference> conferenceList;
    private final AtomicInteger idCounter;

    public ConferenceRepository() {
        this.conferenceList = new ArrayList<>();
        this.idCounter = new AtomicInteger(1);
        //addTestRegisters();
    }

    /**
     * Retorna todas las conferencias
     * 
     * @return
     */
    public ArrayList<Conference> getAllConferences() {
        return conferenceList;
    }

    /**
     * Retorna una conferencia dado un id
     * 
     * @param id
     * @return
     */
    public Conference getConferenceById(Integer id) {
        for (Conference conference : conferenceList) {
            if (conference.getId().equals(id)) {
                return conference;
            }
        }
        return null;
    }

    /**
     * Añade una conferencia
     * 
     * @param conference
     * @return
     */
    public Conference addConference(Conference conference) {
        conference.setId(idCounter.getAndIncrement());
        conferenceList.add(conference);
        return conference;
    }

    /**
     * Actualiza una conferencia
     * 
     * @param conferenceId
     * @param conference
     * @return
     */
    public Conference updateConference(Integer conferenceId, Conference conference) {
        for (Conference c : conferenceList) {
            if (c.getId().equals(conferenceId)) {
                c.setName(conference.getName());
                c.setSubject(conference.getSubject());
                c.setDescription(conference.getDescription());
                return c;
            }
        }
        return null;
    }

    /**
     * Elimina una conferencia
     * 
     * @param conferenceId
     * @return
     */
    public Conference deleteConference(Integer conferenceId) {
        for (Conference c : conferenceList) {
            if (c.getId().equals(conferenceId)) {
                conferenceList.remove(c);
                return c;
            }
        }
        return null;
    }

    public Conference getByChair(Integer userId) {
        for (Conference c : conferenceList) {
            User chair = c.getChair();
            if (chair != null && chair.getId().equals(userId)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Añade registros de prueba
     */
    public final void addTestRegisters() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            addConference(
                    new Conference(1, "International Science Conference", "New York", sdf.parse("10/10/2025"),
                            "Science", "Exploring the latest in scientific research."));
            addConference(
                    new Conference(2, "Global Tech Summit", "San Francisco", sdf.parse("15/11/2025"), "Technology",
                            "Innovations in the tech industry and future trends."));
            addConference(
                    new Conference(3, "Healthcare Advances Forum", "Chicago", sdf.parse("20/12/2025"), "Healthcare",
                            "Discussing advancements in healthcare and medicine."));
        } catch (ParseException e) {
        }
    }
}
