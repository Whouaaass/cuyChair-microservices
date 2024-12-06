package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state;

public interface PaperReviewState{
    /**
     * @brief review califica un paper
     * 
     */
    void review();

    /**
     * @brief getState devuelve un estado
     * @return String del estado encontrado en mayusculas
     */
    String getState();
}

