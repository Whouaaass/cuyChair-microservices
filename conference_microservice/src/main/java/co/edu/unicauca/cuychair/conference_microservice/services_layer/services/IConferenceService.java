package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;


import java.util.List;

import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.PostConferenceDTO;

/**
 * Interfaz de los servicios de la conferencia
 * @author Frdy
 */
public interface IConferenceService {    

    /**
     * Buscar todas las conferencias
     * @return
     */
    public List<ConferenceDTO> findAll();

    /**
     * Buscar una conferencia por su id
     * @param id
     * @return
     */
    public ConferenceDTO findById(Integer id);

    /**
     * Guardar una conferencia
     * @param conference
     * @return
     */
    public ConferenceDTO save(PostConferenceDTO conference);

    /**
     * Actualizar una conferencia
     * @param id
     * @param conference
     * @return
     */
    public ConferenceDTO update(Integer id, ConferenceDTO conference);

    /**
     * Eliminar una conferencia
     * @param id
     * @return
     */
    public boolean delete(Integer id);


    /**
     * Agregar un autor a una conferencia
     * @param conferenceId
     * @param userId
     * @return
     */
    public ConferenceDTO AddAuthor(Integer conferenceId, Integer userId);

    /**
     * Agregar un revisor a una conferencia
     * @param conferenceId
     * @param userId
     * @return
     */
    public ConferenceDTO AddReviewer(Integer conferenceId, Integer userId);

    /**
     * Agregar un paper a una conferencia
     * @param conferenceId id de la conferencia
     * @param paperId id del paper
     * @return la conferencia con el paper agregado
     */
    public ConferenceDTO AddPaper(Integer conferenceId, Integer paperId);   

    /**
     * Obtiene todas las conferencias en las que participa un usuario
     * @param userId id del usuario
     * @return lista de conferencias en las que el usuario participa
     */
    public List<ConferenceDTO> findByUserParticipant(Integer userId);

    /**
     * Obtiene las conferencias en las que un usuario es revisor
     * @param reviewerId id de revisor
     * @return Lista de conferencias
     */
    public List<ConferenceDTO> findByReviewer(Integer userId);

}
