package co.edu.unicauca.cuychair.conference_microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.AddConferencePaperDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.AddConferenceParticipationDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.SimpleConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.services.IConferenceService;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.services.IPaperService;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.services.IUserService;





@RestController
@RequestMapping("/api/conference")
public class ConferenceRestController {

    @Autowired
    private IConferenceService conferenceService;
    @Autowired
    private IPaperService paperService;
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllConferences() {
        return ResponseEntity.ok(conferenceService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> createConference(@RequestBody SimpleConferenceDTO conferenceDTO) {
        ConferenceDTO conference = conferenceService.save(conferenceDTO);
        return new ResponseEntity<>(conference, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateConference(@PathVariable Integer id, @RequestBody ConferenceDTO entity) {
        return new ResponseEntity<>(conferenceService.update(id, entity), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConference(@PathVariable Integer id) {
        return ResponseEntity.ok(conferenceService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConference(@PathVariable Integer id) {
        return new ResponseEntity<>(conferenceService.delete(id), HttpStatus.OK);
    }
        
    @PostMapping("/addAuthor")
    public ResponseEntity<?> addAuthor(@RequestBody AddConferenceParticipationDTO conferenceParticipation) {
        ConferenceDTO conference = this.conferenceService.AddAuthor(conferenceParticipation.getConferenceId(), conferenceParticipation.getUserId());
        return new ResponseEntity<>(conference, HttpStatus.OK);
    }

    @PostMapping("/addReviewer") 
    public ResponseEntity<?> addReviewer(@RequestBody AddConferenceParticipationDTO conferenceParticipation) {
        ConferenceDTO conference = this.conferenceService.AddReviewer(conferenceParticipation.getConferenceId(), conferenceParticipation.getUserId());
        return new ResponseEntity<>(conference, HttpStatus.OK);
    }

    @PostMapping("/addPaper")
    public ResponseEntity<?> addPaper(@RequestBody AddConferencePaperDTO addConferencePaperDTO) {
        ConferenceDTO conference = this.conferenceService.AddPaper(addConferencePaperDTO.getConferenceId(), addConferencePaperDTO.getPaperId());
        return new ResponseEntity<>(conference, HttpStatus.OK);
    }

    @GetMapping("/{id}/papers")
    public ResponseEntity<?> getPapers(@PathVariable Integer id) {
        return ResponseEntity.ok(paperService.findByConferenceId(id));
    }

    @GetMapping("/{id}/authors")
    public ResponseEntity<?> getAuthors(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findByRoleInConference(id, "author"));
    }
    
    @GetMapping("/{id}/reviewers")
    public ResponseEntity<?> getReviewers(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findByRoleInConference(id, "reviewer"));
    }
}
