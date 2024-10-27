package co.edu.unicauca.cuychair.paper_microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Paper {

    private int id;
    private String title;
    private String Abstract;
    private String subtitle;
    private User author;
    private Conference conference;

    public Paper(){}

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Paper){
            return author.getId() == ((Paper) obj).getAuthor().getId();
        }
        return false;
    }
}
