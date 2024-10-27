package co.edu.unicauca.cuychair.user.user_microservice.rabbit.publisher;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.UserDTO;

@Component
@EnableRabbit
public class Publisher {

	private final RabbitTemplate amqpTemplate;
    private final String exchange = "exchangeUser";
    private final String routingKey = "routingKey";

    public Publisher(RabbitTemplate prmAmqpTemplate){
        amqpTemplate=prmAmqpTemplate;
    }

    public void sendUserDTO(UserDTO UserDTO) {
        amqpTemplate.convertAndSend(exchange, routingKey, UserDTO);
    }

    public void sendConferenceDTO(ConferenceDTO conferenceDTO) {
        amqpTemplate.convertAndSend(exchange,routingKey, conferenceDTO);
    }

}
