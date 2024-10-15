package co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.services;

import java.util.List;

import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.ConferenceDTO;;

public interface IConferenceService {
    /**
     * @brief Añade una conferencia al final repositorio
     * @param conferenceDTO conferencia a registrar
     * @return La conferencia añadida
     */
    public ConferenceDTO addConference(ConferenceDTO conferenceDTO);
    /**
     * @brief Lista las conferencias registradas en el repositorio
     * @return Lista de las conferencias registradas
     */
    public List<ConferenceDTO> listConferences();
    /**
     * @brief Actualiza la conferencia indicada por el id
     * @param id id de la conferencia a actualizar
     * @param conferenceDTO datos de la conferencia actualizada
     * @return La conferencia actualizada
     */
    public ConferenceDTO updateConference(int id, ConferenceDTO conferenceDTO);
    /**
     * @brief Consulta la conferencia el id indicado 
     * @param id id de la conferencia consultada
     * @return Conferencia consultada
     */
    public ConferenceDTO getConference(int id);
    /**
     * @brief Consulta una conferencia según su dueño
     * @param idOwner identificación del usuario propietario de la conferencia
     * @return Conferencia consultada
     */
    public ConferenceDTO getConferenceByOwner(int idOwner);
    /** 
     * @brief Elimina la conferencia indicada por el id
     * @param id id de la conferencia a borrar
     * @return La conferencia eliminada
     */
    public ConferenceDTO deleteConference(int id);
    /**
     * @brief Verifica si la conferencia existe
     * @param id id de la conferencia consultada
     * @return si la conferencia existe
     */
    public boolean conferenceExist(int id);
}
