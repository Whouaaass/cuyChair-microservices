package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ConferenceDTO {
    private Integer id;
    private String name;
    private String subject;
    private String description;

}
