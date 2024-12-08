package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output;

import java.util.List;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;

public interface PaperReviewRepositoryPort {
    /**
     * @brief addpaperReview añade un nuevo paperReview 
     * @param paperReview el paperReview a añadir
     * @return paperReview añadido
     */
    paperReview addpaperReview(paperReview paperReview);
    /**
     * @brief busca un paperReview en base al id del artículo
     * @param paperId es el id del paper al que pertenece el paperReview
     * @return paperReviewEncontrado
     */
    paperReview getPaperReview(int paperId);
    /**
     * @brief changeState cambia el estado del paperReview
     * @param paperReviewId es el id del paperReview
     * @param newState String del nuevo estado
     * @return si la operacion tuvo exito
     */
    boolean changeState(int paperReviewId, String newState);
    
    /**
     * @brief deletePaperReview borra el paperReview indicado
     * @param paperReviewId id del paperReview a eliminar
     * @return paperReview eliminado
     */
    paperReview deletePaperReview(int paperReviewId);

    /**
     * @brief lista los paperReview existentes
     * @return la lista de los paperReview encontrados
     */
    List<paperReview> listPaperReview();

}
