package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state;

public interface PaperReviewState{
    /**
     * @brief toModeration pasa el estado a moderacion 
     * @return el resultado del paso a nuevo estado
     */
    Result toModeration();

    /**
     * @brief toDraft pasa el estado a Draft 
     * @return el resultado del paso a nuevo estado
     */
    Result toDraft();

    /**
     * @brief toPublished pasa el estado a Published
     * @return el resultado del paso a nuevo estado
     */
    Result toPublished();

    /**
     * @brief toRejected pasa el estado a Rejected 
     * @return el resultado del paso a nuevo estado
     */
    Result toRejected();
}

