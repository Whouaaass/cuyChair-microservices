package co.edu.unicauca.cuychair.conference_microservice.rabbit.publisher;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO.AMPQConferenceDTO;


@Component
@EnableRabbit
public class Publisher {
    @Autowired
    private RabbitTemplate amqpTemplate;

    public void publishConference(AMPQConferenceDTO conference) {        
        amqpTemplate.convertAndSend(PublisherConfig.EXCHANGE_NAME, PublisherConfig.ROUTING_KEY, conference);
    }
}
