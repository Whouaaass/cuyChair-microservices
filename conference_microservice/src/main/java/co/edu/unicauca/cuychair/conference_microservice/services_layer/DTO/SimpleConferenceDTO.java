package co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Data transfer object for Conference
 */
@Getter
@Setter
@AllArgsConstructor
public class SimpleConferenceDTO {
    private Integer id;
    private String title;
    private String city;
    private Date date;      
    private String description;
    private Integer ownerId;

    public SimpleConferenceDTO() {
        
    }
}