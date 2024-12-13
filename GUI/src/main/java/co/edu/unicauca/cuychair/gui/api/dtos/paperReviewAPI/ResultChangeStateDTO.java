package co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultChangeStateDTO {
    boolean isChangeValid;
    String comment;
}
