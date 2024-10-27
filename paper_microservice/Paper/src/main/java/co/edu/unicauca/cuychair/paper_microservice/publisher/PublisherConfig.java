package co.edu.unicauca.cuychair.paper_microservice.publisher;

import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.PaperDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class PublisherConfig {

    //Cola de publicacion
    @Value("paper_microservice_paperDTO_queue")
    private String messagePaper;

    @Bean
    public Queue queuePaper(){
        return new Queue(messagePaper,true);
    }
}
