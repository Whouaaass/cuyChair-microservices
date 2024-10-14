package co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Data transfer object for Conference
 */
@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {
    private Integer id;
    private String name;
    private String subject;
    private String description;


    public ConferenceDTO() {}
}
