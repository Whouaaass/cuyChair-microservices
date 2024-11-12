package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;

public interface PaperReviewState {
    /**
     * @brief hace una revisión al estado del paperReview
     * con el poder de cambiarlo en la función
     */
    void review();
    /**
     * @brief devuelve el estado del paper
     * @return estado del paperen un string
     */
    String getState();
}
