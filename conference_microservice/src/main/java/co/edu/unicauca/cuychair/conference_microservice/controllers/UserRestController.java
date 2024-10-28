package co.edu.unicauca.cuychair.conference_microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.conference_microservice.services_layer.services.IUserService;



@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private IUserService userService;
    
    @GetMapping("")
    public ResponseEntity<?> listUsersOfConference() {
        return ResponseEntity.ok(userService.findAll());
    }
    
}
