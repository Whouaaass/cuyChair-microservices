package co.edu.unicauca.cuychair.paper_microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Paper implements Cloneable{

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
            return author.getId() == ((Paper) obj).getAuthor().getId() && this.id == ((Paper) obj).getId();
        }
        return false;
    }

    @Override
    public Paper clone() throws CloneNotSupportedException {
        try {
            Paper clone= (Paper) this.getClass().newInstance();
            clone.setTitle(this.getTitle());
            clone.setAbstract(this.getAbstract());
            clone.setSubtitle(this.getSubtitle());
            clone.setAuthor(new User());
            clone.setConference(new Conference());
            clone.setAuthor(this.getAuthor());
            clone.setConference(this.getConference());
            return clone;
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
}
