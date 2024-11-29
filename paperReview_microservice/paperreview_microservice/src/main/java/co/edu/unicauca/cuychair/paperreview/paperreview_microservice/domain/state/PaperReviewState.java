package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.paperReview;

public abstract class PaperReviewState {

    protected paperReview paperreview;

    /**
     * @brief hace una revisión al estado del paperReview
     * con el poder de cambiarlo en la función
     */
    void review() {

    }

    /**
     * @return estado del paperen un string
     * @brief devuelve el estado del paper
     */
    String getState() {
        return null;
    }
}
