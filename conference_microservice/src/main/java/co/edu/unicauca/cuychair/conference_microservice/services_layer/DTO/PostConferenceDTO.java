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
public class PostConferenceDTO {
    private Integer id;
    private String title;
    private String city;
    private Date date;      
    private String description;
    private String subject;
    private Integer ownerId;

    public PostConferenceDTO() {
        
    }

    @Override
    public String toString() {
        return "PostConferenceDTO [city=" + city + ", date=" + date + ", description=" + description + ", id=" + id
                + ", ownerId=" + ownerId + ", subject=" + subject + ", title=" + title + "]";
    }
}