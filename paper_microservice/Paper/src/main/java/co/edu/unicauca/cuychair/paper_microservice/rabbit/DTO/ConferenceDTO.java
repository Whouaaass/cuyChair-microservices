package co.edu.unicauca.cuychair.paper_microservice.rabbit.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {    
    private int id;
    private String title;
    private String city;
    private String date;
    private List<Integer> authorIds;
    private List<Integer> reviewerIds;
    private Integer ownerId;

    public ConferenceDTO(){};


    @Override
    public String toString() {
        return "ConferenceDTO [authorIds=" + authorIds + ", city=" + city + ", date=" + date + ", id=" + id + ", ownerId="
                + ownerId + ", reviewerIds=" + reviewerIds + ", title=" + title + "]";
    }
}