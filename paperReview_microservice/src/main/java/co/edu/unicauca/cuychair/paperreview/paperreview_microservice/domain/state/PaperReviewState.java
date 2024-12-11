package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, // Identifica la implementación mediante un nombre
    include = JsonTypeInfo.As.PROPERTY,
    property = "type" // Campo JSON para identificar el tipo
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Moderation.class, name = "Moderation"),
    @JsonSubTypes.Type(value = Draft.class, name = "Draft"),
    @JsonSubTypes.Type(value = Published.class, name = "Published"),
    @JsonSubTypes.Type(value = Rejected.class, name = "Rejected")
})
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

