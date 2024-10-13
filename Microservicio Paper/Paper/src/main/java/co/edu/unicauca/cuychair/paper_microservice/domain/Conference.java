package co.edu.unicauca.cuychair.paper_microservice.domain;

public class Conference {

    private int id;
    private String title;
    private String description;
    private String city;

    public Conference(int fldId, String fldTitle, String fldDescription, String fldCity) {
        this.id = fldId;
        this.title = fldTitle;
        this.description = fldDescription;
        this.city = fldCity;
    }

    public Conference() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
