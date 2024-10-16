package co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaperDTO {
    private int id;
    private String title;
    private String description;
    private UserDTO author;

    public PaperDTO() {
    }

    public void set(PaperDTO paperDTO){
        this.id = paperDTO.id;
        this.title = paperDTO.title;
        this.description = paperDTO.description;
        this.author = paperDTO.author;
    }
}
