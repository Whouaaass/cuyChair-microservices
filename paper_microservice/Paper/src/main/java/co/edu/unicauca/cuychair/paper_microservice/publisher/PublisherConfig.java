package co.edu.unicauca.cuychair.paper_microservice.publisher;

import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.PaperDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
public class PublisherConfig {

    //Cola de publicacion
    @Value("ijiji")
    private String messagePaper;

    @Bean
    public Queue queuePaper(){
        return new Queue(messagePaper,true);
    }

    @Value("")
    private String messageListPaper;
    @Bean
    public Queue queueListPaper(){
        return new Queue(messageListPaper,true);
    }


}
