package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;

import java.util.List;

import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.PaperDTO;

/**
 * Interfaz de los servicios de Paper
 */
public interface IPaperService {
    
    /**
     * Buscar todos los papers
     * @return
     */
    public List<PaperDTO> findAll();

    /**
     * Buscar un paper por su id
     * @param id
     * @return
     */
    public PaperDTO findById(Integer id);

    /**
     * Guardar un paper
     * @param paper
     * @return
     */
    public PaperDTO save(PaperDTO paper);

    /**
     * Actualizar un paper
     * @param id
     * @param paper
     * @return
     */
    public PaperDTO update(Integer id, PaperDTO paper);

    /**
     * Eliminar un paper
     * @param id
     * @return
     */
    public boolean delete(Integer id);
}
