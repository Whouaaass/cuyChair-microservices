package co.edu.unicauca.cuychair.paper_microservice.publisher;

import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.PaperDTO;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("paperQueue")
    private Queue queue;

    public void sendPaperDTO(PaperDTO paperDTO) {
        rabbitTemplate.convertAndSend(queue.getName(), paperDTO);
    }

    @Autowired
    @Qualifier("paperQueue")
    private Queue queue;

    public void sendListPaperDTO(List<PaperDTO> papers) {
        rabbitTemplate.convertAndSend(queue.getName(), papers);
    }
}
