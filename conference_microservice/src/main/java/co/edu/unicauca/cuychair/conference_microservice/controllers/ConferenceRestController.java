package co.edu.unicauca.cuychair.conference_microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.services.IConferenceService;



@RestController
@RequestMapping("/api/conference")
public class ConferenceRestController {

    @Autowired
    private IConferenceService conferenceService;

    @GetMapping("")
    public ResponseEntity<?> getAllConferences() {
        return ResponseEntity.ok(conferenceService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> createConference(@RequestBody ConferenceDTO conferenceDTO) {
        return new ResponseEntity<>(conferenceService.save(conferenceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateConference(@PathVariable Integer id, @RequestBody ConferenceDTO entity) {
        return new ResponseEntity<>(conferenceService.update(id, entity), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConference(@PathVariable Integer id) {
        return ResponseEntity.ok(conferenceService.findById(id));
    }
    
}
