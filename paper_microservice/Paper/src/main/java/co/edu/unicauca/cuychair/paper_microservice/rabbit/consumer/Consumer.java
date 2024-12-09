package co.edu.unicauca.cuychair.paper_microservice.rabbit.consumer;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.ConferenceDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorUserDTO;
import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
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
        makeSlow();
    }

    @RabbitListener(queues = { "${cuychair.rabbitmq.queue.conference.paper}" })
    public void receiveConference(@Payload ConferenceDTO conferenceDTO) {
        ConversorConferenceDTO maperConference = new ConversorConferenceDTO();
        log.info("Received message {} Conference title: {}", conferenceDTO, conferenceDTO.getTitle());
        ArrayList<User> authors=new ArrayList<>();
        ArrayList<User> reviewers=new ArrayList<>();
        for(int id: conferenceDTO.getAuthors()){
            authors.add(userStoreService.getUserById(id));
        }
        for(int id: conferenceDTO.getReviewers()){
            reviewers.add(userStoreService.getUserById(id));
        }
        conferenceStoreService.addConference(maperConference.toConference(conferenceDTO,authors,reviewers,userStoreService.getUserById(conferenceDTO.getOwner())));
        makeSlow();
    }

    private void makeSlow() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
