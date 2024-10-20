package co.edu.unicauca.cuychair.user.user_microservice.dataAccess.repository;

import java.util.List;

import co.edu.unicauca.cuychair.user.user_microservice.domain.ConferenceEntity;

public interface IConferenceRepository {
    /**
     * @brief Añade una conferencia al final del repositorio
     * @param conference conferencia a registrar
     * @return La conferencia añadida
     */
    public ConferenceEntity addConference(ConferenceEntity conference);
    /**
     * @brief Lista las conferencias registradas en el repositorio
     * @return Lista de las conferencias registradas
     */
    public List<ConferenceEntity> listConferences();
    /**
     * @brief Actualiza la conferencia indicada por el id
     * @param id id de la conferencia a actualizar
     * @param conference datos de la conferencia actualizada
     * @return La conferencia actualizada
     */
    public ConferenceEntity updateConference(int id, ConferenceEntity conference);
    /**
     * @brief Consulta la conferencia el id indicado 
     * @param id id de la conferencia consultada
     * @return Conferencia consultada
     */
    public ConferenceEntity getConference(int id);
    /**
     * @brief Consulta una conferencia según su dueño
     * @param idOwner identificación del usuario propietario de la conferencia
     * @return Conferencia consultada
     */
    public ConferenceEntity getConferenceByOwner(int idOwner);
    /** 
     * @brief Elimina la conferencia indicada por el id
     * @param id id de la conferencia a borrar
     * @return La conferencia eliminada
     */
    public ConferenceEntity deleteConference(int id);
    /**
     * @brief Verifica si la conferencia existe
     * @param id id de la conferencia consultada
     * @return si la conferencia existe
     */
    public boolean conferenceExist(int id);
}
