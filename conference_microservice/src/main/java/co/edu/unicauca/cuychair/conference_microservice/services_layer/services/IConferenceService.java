package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;


import java.util.List;

import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ConferenceDTO;

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
    public ConferenceDTO save(ConferenceDTO conference);

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
}
