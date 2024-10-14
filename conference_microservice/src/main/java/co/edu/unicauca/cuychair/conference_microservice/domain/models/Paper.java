package co.edu.unicauca.cuychair.conference_microservice.domain.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Paper {
    @NonNull private Integer id;
    @NonNull private String title;
    @NonNull private String subtitle;
    @NonNull private String Abstract;    

    private User author;

    public Paper() {
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setAbstract(String abstractIn) {
        this.Abstract = abstractIn;
    }
    
}
