package co.edu.unicauca.cuychair.user.user_microservice.publisher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class PublisherConfig {
	
    @Value("${co.edu.unicauca.cuychair.user.userDTO.queue}")
    private String messageUserDTO;

    @Bean
    public Queue userQueue() {
        return new Queue(messageUserDTO, true);
    }

    @Value("${co.edu.unicauca.cuychair.user.conferenceDTO.queue}")
    private String messageConferenceDTO;

    @Bean
    public Queue conferenceQueue() {
        return new Queue(messageConferenceDTO, true);
    }

    @Value("${co.edu.unicauca.cuychair.user.userListDTO.queue}")
    private String messageUserListDTO;

    @Bean
    public Queue userListQueue() {
        return new Queue(messageUserListDTO, true);
    }
}

