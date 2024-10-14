package co.edu.unicauca.cuychair.conference_microservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/user")
public class UserRestController {
    
    @GetMapping("path")
    public String listUsersOfConference(@RequestParam String param) {
        return "Aún no implementado " + param;
    }
    
}
