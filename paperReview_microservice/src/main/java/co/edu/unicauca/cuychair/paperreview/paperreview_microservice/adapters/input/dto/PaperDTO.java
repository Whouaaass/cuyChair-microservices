package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PaperDTO {
    private int id;
    private String title;
    private String Abstract;
    private String subTitle;
    private int idAuthor;
    private int idConference;
}
