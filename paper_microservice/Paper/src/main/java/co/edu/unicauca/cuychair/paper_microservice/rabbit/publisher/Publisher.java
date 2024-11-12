package co.edu.unicauca.cuychair.paper_microservice.rabbit.publisher;

import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.PaperDTO;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendPaperDTO(PaperDTO paperDTO) {
        rabbitTemplate.convertAndSend(PublisherConfig.EXCHANGE_NAME, PublisherConfig.ROUTING_KEY, paperDTO);
    }
}
