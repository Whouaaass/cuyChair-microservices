package co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PaperDTO {
    private int id;
    private String title;
    private String description;
    private int idAuthor;
    private int idConference;

    public PaperDTO() {
    }
}
