package co.edu.unicauca.cuychair.paper_microservice.rabbit.consumer;

import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorUserDTO;
import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.ConferenceStoreService;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.UserStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @Autowired
    UserStoreService userStoreService;

    @Autowired
    ConferenceStoreService conferenceStoreService;

    @RabbitListener(queues = { "${co.edu.unicauca.cuychair.user.userDTO.queue}" })
    public void receiveUser(@Payload UserDTO userDTO){
        ConversorUserDTO maperUser= new ConversorUserDTO();
        log.info("Received message {} User name: {}", userDTO, userDTO.getName());
        User user=maperUser.toUser(userDTO);
        userStoreService.addUser(user);
        makeSlow();
    }

    @RabbitListener(queues = { "${co.edu.unicauca.cuychair.user.conferenceDTO.queue}" })
    public void receiveConference(@Payload ConferenceDTO conferenceDTO){
        ConversorConferenceDTO maperConference= new ConversorConferenceDTO();
        log.info("Received message {} Conference title: {}", conferenceDTO, conferenceDTO.getTitle());
        Conference conference=maperConference.toConference(conferenceDTO);
        conferenceStoreService.addConference(conference);
        makeSlow();
    }

    private void makeSlow() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
