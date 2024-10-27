package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO;

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
