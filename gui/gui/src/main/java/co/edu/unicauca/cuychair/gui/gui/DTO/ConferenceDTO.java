/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.DTO;


import java.util.ArrayList;


public class ConferenceDTO {
    public ConferenceDTO(){};
    private int id;
    private String title;
    private String city;
    private String date;
    private ArrayList<UserDTO> participantsList;
    private UserDTO owner;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<UserDTO> getParticipantsList() {
        return participantsList;
    }

    public void setParticipantsList(ArrayList<UserDTO> participantsList) {
        this.participantsList = participantsList;
    }

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }
    
}
