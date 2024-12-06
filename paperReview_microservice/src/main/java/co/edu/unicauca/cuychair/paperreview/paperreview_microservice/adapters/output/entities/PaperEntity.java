package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaperEntity {
    private int id;
    private String title;
    private String Abstract;
    private String subtitle;
    private int author;
    private int conference;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PaperEntity) {
            PaperEntity other = (PaperEntity) obj;
            return id == other.getId() ;
        }
        return super.equals(obj);
    }
}
