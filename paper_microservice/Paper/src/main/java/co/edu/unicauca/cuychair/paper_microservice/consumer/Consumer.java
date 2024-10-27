package co.edu.unicauca.cuychair.paper_microservice.consumer;

import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.UserDTO;
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
        log.info("Received message {} User name: {}", userDTO, userDTO.getName());
        System.out.println(userStoreService.addUser(userDTO));
        makeSlow();
    }

    @RabbitListener(queues = { "${co.edu.unicauca.cuychair.user.conferenceDTO.queue}" })
    public void receiveConference(@Payload ConferenceDTO conferenceDTO){
        log.info("Received message {} Conference title: {}", conferenceDTO, conferenceDTO.getTitle());
        conferenceStoreService.addConference(conferenceDTO);
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
