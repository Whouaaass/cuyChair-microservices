package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Conference {

    private int id;
    private String title;
    private String description;
    private String city;
    private List<Paper> listPapers ;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Conference){
            return id==((Conference)obj).getId();
        }
        return false;
    }
}
