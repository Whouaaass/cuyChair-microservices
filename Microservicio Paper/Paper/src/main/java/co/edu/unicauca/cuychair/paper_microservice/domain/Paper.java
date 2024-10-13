package co.edu.unicauca.cuychair.paper_microservice.domain;

public class Paper {

    private int id;
    private String title;
    private String description;
    protected User author;
    protected Conference conference;


    public Paper(String fldTitle, String fldDescription, User fldAuthor, Conference fldConference) {
        this.title = fldTitle;
        this.description = fldDescription;
        this.author = fldAuthor;
        this.conference = fldConference;
    }

    public Paper() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Paper){
            return id == ((Paper) obj).getId();
        }
        return false;
    }
}
