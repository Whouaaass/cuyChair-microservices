package co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Paper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ConferenceDTO {
    private int id;
    private String name;
    private String subject;
    private String description;

}
