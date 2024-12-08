package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.rabbit;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServicesPaperPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.dto.PaperDTO;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.maper.PaperDTOMaper;
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
    @RabbitListener(queues = "${cuychair.rabbitmq.queue.paper.review}")
    public void listenPaper(@Payload PaperDTO paper) {
        PaperDTOMaper maper = new PaperDTOMaper();
        PaperDTO pa=maper.toPaperDTO(services.findById(paper.getId()));
        if(pa!=null) {
            if(pa.getTitle().equals(paper.getTitle()) && pa.getSubTitle().equals(paper.getSubTitle()) && pa.getAbstract().equals(paper.getAbstract())) {
                services.removePaper(maper.toPaper(paper));
            }else{
                services.updatePaper(maper.toPaper(paper));
            }
        }
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
