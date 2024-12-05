package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.rabbit;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.dto.PaperDTO;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.maper.PaperDTOMaper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input.ServicesPaperPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaperLisenerAdapter {

    private final ServicesPaperPort services;

    public PaperLisenerAdapter(ServicesPaperPort services) {
        this.services = services;
    }
    @RabbitListener(queues = "${co.edu.unicauca.cuychair.paper.paperDTO.queue}")
    public void listenPaper(@Payload PaperDTO paper) {
        PaperDTOMaper maper = new PaperDTOMaper();
        services.addPaper(maper.toPaper(paper));
        makeSlow();
    }

    private void makeSlow() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
