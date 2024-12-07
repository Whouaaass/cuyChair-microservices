package co.edu.unicauca.cuychair.paper_microservice.rabbit.publisher;

import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorPaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendPaperDTO(Paper paper) {
        ConversorPaperDTO maperPaper=new ConversorPaperDTO();
        rabbitTemplate.convertAndSend(PublisherConfig.EXCHANGE_NAME, PublisherConfig.ROUTING_KEY, maperPaper.toPaperDTO(paper));
    }
}
