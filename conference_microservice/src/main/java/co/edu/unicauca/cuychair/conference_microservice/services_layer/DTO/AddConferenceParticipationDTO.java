package co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddConferenceParticipationDTO {
    private Integer conferenceId;
    private Integer userId;
    

    public AddConferenceParticipationDTO() {}
}
