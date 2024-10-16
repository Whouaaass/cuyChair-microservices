package co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Paper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ConferenceDTO {
    private int id;
    private String title;
    private String description;
    private String city;
    private List<PaperDTO> listPapers ;

    public ConferenceDTO() {}

    public void set (ConferenceDTO conferenceDTO){
        this.id=conferenceDTO.id;
        this.title= conferenceDTO.title;
        this.description= conferenceDTO.description;
        this.city= conferenceDTO.city;
        this.listPapers=conferenceDTO.listPapers;
    }
}
