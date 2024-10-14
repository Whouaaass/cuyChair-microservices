package co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PaperDTO {
    private Integer id;
    private String title;
    private String Abstract;
    private String subtitle;

    public PaperDTO() {
    }
}
