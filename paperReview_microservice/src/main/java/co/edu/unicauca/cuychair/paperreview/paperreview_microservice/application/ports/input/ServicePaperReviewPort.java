package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Result;

public interface ServicePaperReviewPort {
    /**
     * @brief addpaperReview añade un nuevo paperReview 
     * @param paperReview el paperReview a añadir
     * @return paperReview añadido
     */
    paperReview addpaperReview(paperReview paperReview);
    
    /**
     * @brief busca un paperReview en base a los id de la conferencia y el artículo
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
    public Result changeState(int paperReviewId, String newState);

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
    /**
     * @brief getPaperReviewByPaper trae un paperReview segun su paper de origen
     * @param paperId El id del paper en cuestion
     * @return paperReview encontrado
     */
    public paperReview getPaperReviewByPaper(int paperId);
    /**
     * @brief listPaperReviewsByReviewer lista los paperReview según su conferencia
     * @param conferenceId 
     * @return
     */
    public List<paperReview> listPaperReviewsByConference(@PathVariable int conferenceId);
}
