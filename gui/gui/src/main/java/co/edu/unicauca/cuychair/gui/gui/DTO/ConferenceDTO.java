/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.DTO;


import java.util.ArrayList;
import java.util.Date;


public class ConferenceDTO {
    
    private Integer id;
    private String title;
    private String city;
    private Date date;    
        
    private ArrayList<UserDTO> reviewers;
    private ArrayList<UserDTO> authors;   
    private UserDTO owner;

    public ConferenceDTO(){};    

    //id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //city
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    //date
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    //authors
    public ArrayList<UserDTO> getAuthors() {
        return authors;
    }
    public void setAuthors(ArrayList<UserDTO> authors) {
        this.authors = authors;
    }

    //reviewers
    public ArrayList<UserDTO> getReviewers() {
        return reviewers;
    }
    public void setReviewers(ArrayList<UserDTO> reviewers) {
        this.reviewers = reviewers;
    }

    //owner
    public UserDTO getOwner() {
        return owner;
    }
    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }
    
}
