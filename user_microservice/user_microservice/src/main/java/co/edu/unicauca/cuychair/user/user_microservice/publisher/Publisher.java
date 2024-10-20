package co.edu.unicauca.cuychair.user.user_microservice.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.UserDTO;

@Component
@EnableRabbit
public class Publisher {
	
    @Autowired
	private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;
    public void sendUserDTO(UserDTO UserDTO) {
        rabbitTemplate.convertAndSend(queue.getName(), UserDTO);
    }
}
