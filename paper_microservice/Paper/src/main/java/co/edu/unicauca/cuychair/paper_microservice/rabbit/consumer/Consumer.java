package co.edu.unicauca.cuychair.paper_microservice.rabbit.consumer;

import java.util.ArrayList;

import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.ConferenceDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorUserDTO;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.ConferenceStoreService;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.UserStoreService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

    @Autowired
    UserStoreService userStoreService;

    @Autowired
    ConferenceStoreService conferenceStoreService;

    @RabbitListener(queues = { "${cuychair.rabbitmq.queue.user.paper}" })
    public void receiveUser(@Payload UserDTO userDTO) {
        ConversorUserDTO maperUser = new ConversorUserDTO();
        log.info("Received message {} User name: {}", userDTO, userDTO.getName());
        User user = maperUser.toUser(userDTO);
        userStoreService.addUser(user);
        System.out.println("Resivido");
        makeSlow();
    }

    @RabbitListener(queues = { "${cuychair.rabbitmq.queue.conference.paper}" })
    public void receiveConference(@Payload ConferenceDTO conferenceDTO) {
        makeSlow();
        ConversorConferenceDTO maperConference = new ConversorConferenceDTO();
        log.info("Received message {} Conference title: {}", conferenceDTO, conferenceDTO.getTitle());
        ArrayList<User> authors=new ArrayList<>();
        ArrayList<User> reviewers=new ArrayList<>();
        for(int id: conferenceDTO.getReviewerIds()){
            try {
                reviewers.add(userStoreService.getUserById(id));                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        for(int id: conferenceDTO.getAuthorIds()){
            try {
                authors.add(userStoreService.getUserById(id));                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        try {
        conferenceStoreService.addConference(maperConference.toConference(conferenceDTO,authors,reviewers,userStoreService.getUserById(conferenceDTO.getOwnerId())));
        } catch (Exception e) {
            log.atWarn().log("Invalid Conference with id {}: {}", conferenceDTO.getId(), e.getMessage());
        }        
    }

    private void makeSlow() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
