package co.edu.unicauca.cuychair.conference_microservice.data_access;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.Conference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Repositorio de conferencias
 */
@Repository
public class ConferenceRepository {    
    
    private final ArrayList<Conference> conferenceList;
    private final AtomicInteger idCounter;

    public ConferenceRepository() {
        this.conferenceList = new ArrayList<Conference>();
        this.idCounter = new AtomicInteger(1);
        addTestRegisters();
    }

    /**
     * Retorna todas las conferencias
     * @return
     */
    public ArrayList<Conference> getAllConferences() {
        return conferenceList;
    }

    /**
     * Retorna una conferencia dado un id
     * @param id
     * @return
     */
    public Conference getConferenceById(int id) {
        for (Conference conference : conferenceList) {
            if (conference.getId() == id) {
                return conference;
            }
        }
        return null;
    }

    /**
     * Añade una conferencia
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
     * @param conferenceId 
     * @param conference
     * @return
     */
    public Conference updateConference(Integer conferenceId, Conference conference) {                
        for (Conference c : conferenceList) {
            if (c.getId() == conferenceId) {
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
     * @param conferenceId
     * @return
     */
    public Conference deleteConference(Integer conferenceId) {
        for (Conference c : conferenceList) {
            if (c.getId() == conferenceId) {
                conferenceList.remove(c);
                return c;
            }
        }
        return null;
    }

    /**
     * Añade registros de prueba
     */
    public void addTestRegisters() {
        addConference(new Conference(1, "Conference 1", "Subject 1", "Description 1"));
        addConference(new Conference(2, "Conference 2", "Subject 2", "Description 2"));
        addConference(new Conference(3, "Conference 3", "Subject 3", "Description 3"));
    }    
}
