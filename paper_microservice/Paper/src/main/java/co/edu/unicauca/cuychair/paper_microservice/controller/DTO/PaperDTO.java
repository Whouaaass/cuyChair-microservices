package co.edu.unicauca.cuychair.paper_microservice.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PaperDTO {
    private int id;
    private String title;
    private String Abstract;
    private String subTitle;
    private int idAuthor;
    private int idConference;

    @Override
    public String toString() {
        return "PaperDTO [id=" + id + ", title=" + title + ", Abstract=" + Abstract + ", subTitle=" + subTitle+"]";
    }
}
