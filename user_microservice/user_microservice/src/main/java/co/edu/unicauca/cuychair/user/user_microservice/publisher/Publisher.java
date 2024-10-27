package co.edu.unicauca.cuychair.user.user_microservice.publisher;
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
	
    @Autowired
	private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("userQueue")
    private Queue userQueue;
    
    public void sendUserDTO(UserDTO UserDTO) {
        rabbitTemplate.convertAndSend(userQueue.getName(), UserDTO);
    }

    @Autowired
    @Qualifier("conferenceQueue")
    private Queue conferenceQueue;
    
    public void sendConferenceDTO(ConferenceDTO conferenceDTO) {
        rabbitTemplate.convertAndSend(conferenceQueue.getName(), conferenceDTO);
    }

}
