/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Data transfer object for Conference
 */
@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {
    private Integer id;
    private String name;
    private String subject;
    private String description;


    public ConferenceDTO() {}
}