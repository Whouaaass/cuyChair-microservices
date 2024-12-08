package co.edu.unicauca.cuychair.paper_microservice.rabbit.publisher;

import org.springframework.amqp.core.DirectExchange;

import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorPaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${cuychair.rabbitmq.exchange.paper}")
    private String EXCHANGE_NAME;

    @Value("${cuychair.rabbitmq.exchange.paper.routingkey}")
    private String ROUTING_KEY;


    
    public void sendPaperDTO(Paper paper) {
        ConversorPaperDTO maperPaper = new ConversorPaperDTO();
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, maperPaper.toPaperDTO(paper));
    }
}
