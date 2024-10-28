package co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AddConferencePaperDTO {
    private Integer conferenceId;
    private Integer paperId;

    public AddConferencePaperDTO() {}
}
