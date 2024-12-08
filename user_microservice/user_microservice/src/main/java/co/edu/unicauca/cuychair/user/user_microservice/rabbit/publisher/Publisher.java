package co.edu.unicauca.cuychair.user.user_microservice.rabbit.publisher;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.UserDTO;

@Component
@EnableRabbit
public class Publisher {

    @Autowired
    private RabbitTemplate amqpTemplate;

    @Value("${cuychair.rabbitmq.exchange.user.routingkey}")
    private String USER_ROUTING_KEY;

    @Value("${cuychair.rabbitmq.exchange.user}")
    private String USER_EXCHANGE;    

    public void sendUserDTO(UserDTO UserDTO) {
        amqpTemplate.convertAndSend(USER_EXCHANGE, USER_ROUTING_KEY, UserDTO);
    }
}
