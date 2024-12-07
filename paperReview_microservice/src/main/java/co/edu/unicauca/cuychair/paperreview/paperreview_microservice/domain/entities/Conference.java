package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities;

import java.util.ArrayList;
import java.util.Date;

public class Conference {
    private int id;
    private String title;
    private String city;
    private Date date;

    private ArrayList<User> reviewers;
    private ArrayList<User> authors;

    private User owner;

    public Conference(){}

    public Conference(int id, String title, String city, Date date, ArrayList<User> reviewers, ArrayList<User> authors, User owner) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.date = date;
        this.reviewers = reviewers;
        this.authors = authors;
        this.owner = owner;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<User> getReviewers() {
        return reviewers;
    }

    public void setReviewers(ArrayList<User> reviewers) {
        this.reviewers = reviewers;
    }

    public ArrayList<User> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<User> authors) {
        this.authors = authors;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
