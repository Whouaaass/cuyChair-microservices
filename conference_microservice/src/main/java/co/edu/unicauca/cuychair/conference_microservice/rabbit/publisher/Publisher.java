package co.edu.unicauca.cuychair.conference_microservice.rabbit.publisher;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO.AMPQConferenceDTO;

@Component
@EnableRabbit
public class Publisher {
    @Autowired
    private RabbitTemplate amqpTemplate;

    @Value("${cuychair.rabbitmq.exchange.conference}")
    private String EXCHANGE_NAME;

    @Value("${cuychair.rabbitmq.exchange.conference.routingkey}")
    private String ROUTING_KEY;

    public void publishConference(AMPQConferenceDTO conference) {
        amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, conference);
    }
}
