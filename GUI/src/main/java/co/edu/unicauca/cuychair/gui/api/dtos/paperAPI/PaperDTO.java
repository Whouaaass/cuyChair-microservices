package co.edu.unicauca.cuychair.gui.api.dtos.paperAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaperDTO {
    private int id;
    private String title;
    @JsonProperty("abstract")
    private String Abstract;
    private String subTitle;
    private int idAuthor;
    private int idConference;
    public PaperDTO(){};
    
}
