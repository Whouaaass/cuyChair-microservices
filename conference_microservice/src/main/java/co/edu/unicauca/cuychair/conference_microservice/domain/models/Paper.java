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

    private Conference conference;

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

    // user
    public User getAuthor() {
        return this.author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }

    // conference
    public Conference getConference() {
        return this.conference;
    }
    public void setConference(Conference conference) {
        this.conference = conference;
    }
    
    
}
