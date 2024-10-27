/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.List;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.cuychair.gui.gui.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.gui.gui.DTO.PaperDTO;

@Service
public class conferenceController {
    @Autowired
    private WebClient.Builder webClientBuilder;
    
    //Trae todas las conferencias
    public List<ConferenceDTO> getAllConferences() {
        //TODO revisar si es la url correcta
        String url = "http://localhost:8092/conference_microservice/Conferences";

        Mono<ConferenceDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ConferenceDTO[].class);

        ConferenceDTO[] ConferencesDTOList = response.block();
        return ConferencesDTOList != null ? List.of(ConferencesDTOList) : List.of();
    }

    //Trae todos los papers de una conferencia
    public List<PaperDTO> getAllConferencePapers() {
        //TODO revisar si es la url correcta
        String url = "http://localhost:8092/conference_microservice/getPapersFromConference";

        Mono<PaperDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(PaperDTO[].class);

                PaperDTO[] PaperDTOList = response.block();
        return PaperDTOList != null ? List.of(PaperDTOList) : List.of();
    }
}
