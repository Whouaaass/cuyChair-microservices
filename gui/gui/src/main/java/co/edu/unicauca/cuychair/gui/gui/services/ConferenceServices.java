/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.services;

import co.edu.unicauca.cuychair.gui.gui.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.gui.gui.controller.ConferenceController;
import java.util.List;

/**
 *
 * @author julia
 */
public class ConferenceServices {
    ConferenceController conferenceController;
    public ConferenceServices(){
        conferenceController = new ConferenceController();
    }
    public List<ConferenceDTO> getAllConferences(){
        return conferenceController.getAllConferences();
    }
}
