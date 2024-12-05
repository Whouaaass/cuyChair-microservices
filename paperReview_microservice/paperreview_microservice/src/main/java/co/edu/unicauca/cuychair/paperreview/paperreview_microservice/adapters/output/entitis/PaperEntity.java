package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entitis;

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
}
