package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain;

public class Paper {
    private int id;
    private String title;
    private String Abstract;
    private String subtitle;
    private int author;
    private int conference;

    public Paper(){}

    public Paper(int id, String title, String anAbstract, String subtitle, int author, int conference) {
        this.id = id;
        this.title = title;
        Abstract = anAbstract;
        this.subtitle = subtitle;
        this.author = author;
        this.conference = conference;
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

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getConference() {
        return conference;
    }

    public void setConference(int conference) {
        this.conference = conference;
    }
}
