package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.rabbit;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServicePaperReviewPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServicesPaperPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Paper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;
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
    private final ServicePaperReviewPort servicesPaperReview;

    public PaperLisenerAdapter(ServicesPaperPort services, ServicePaperReviewPort servicesPaperReview) {
        this.services = services;
        this.servicesPaperReview=servicesPaperReview;
    }
    @RabbitListener(queues = "${cuychair.rabbitmq.queue.paper.review}")
    public void listenPaper(@Payload PaperDTO paper) {
        PaperDTOMaper maper = new PaperDTOMaper();
        Paper find=services.findById(paper.getId());
        if(find!=null) {
            PaperDTO pa = maper.toPaperDTO(find);
            if (pa != null) {
                if (pa.getTitle().equals(paper.getTitle()) && pa.getSubTitle().equals(paper.getSubTitle()) && pa.getAbstract().equals(paper.getAbstract())) {
                    services.removePaper(maper.toPaper(paper));
                } else {
                    services.updatePaper(maper.toPaper(paper));
                }
                return;
            }
        }
        services.addPaper(maper.toPaper(paper));
        System.out.println("Recibido");
        Paper pa=maper.toPaper(paper);
        paperReview review=new paperReview(0,pa,null,false,"",null,null);
        servicesPaperReview.addpaperReview(review);
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
