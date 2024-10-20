package co.edu.unicauca.cuychair.user.user_microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.services.ConferenceService;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.ConferenceDTO;

@RestController
@RequestMapping("/user_microservice/conference")
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService){
        this.conferenceService = conferenceService;
    }

    @GetMapping("/sendConference/{id}")
    public ConferenceDTO SendConference(@PathVariable int id){
        return conferenceService.sendConferenceToRabbit(id);
    }

    @PostMapping("/addConference")
    public ConferenceDTO addConference(@RequestBody ConferenceDTO conferenceDTO) {
        return conferenceService.addConference(conferenceDTO);
    }

    @GetMapping("/listConferences")
    public List<ConferenceDTO> listConferences() {
        return conferenceService.listConferences();
    }

    @PutMapping("/updateConference/{id}")
    public ConferenceDTO updateConference(@PathVariable int id,@RequestBody ConferenceDTO conferenceDTO) {
        return conferenceService.updateConference(id,conferenceDTO);
    }

    @GetMapping("/getConference/{id}")
    public ConferenceDTO getConference(@PathVariable int id) {
        return conferenceService.getConference(id);
    }

    @GetMapping("/getConferenceByOwner/{idOwner}")
    public ConferenceDTO getConferenceByOwner(@PathVariable int idOwner) {
        return conferenceService.getConferenceByOwner(idOwner);
    }

    @DeleteMapping("/deleteConference/{id}")
    public ConferenceDTO deleteConference(@PathVariable int id) {
        return conferenceService.deleteConference(id);
    }

    @GetMapping("/conferenceExist/{id}")
    public boolean conferenceExist(@PathVariable int id) {
        return conferenceService.conferenceExist(id);
    }
    
}
