package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.rabbit;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServiceConferencePort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.dto.ConferenceDTO;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.maper.ConferenceDTOMaper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConferenceLisenerAdapter {

    private final ServiceConferencePort services;

    public ConferenceLisenerAdapter(ServiceConferencePort services) {
        this.services = services;
    }
    @RabbitListener(queues = { "${cuychair.rabbitmq.queue.conference.review}" })
    public void listenConference(@Payload ConferenceDTO conferenceDTO) {
        ConferenceDTOMaper maper = new ConferenceDTOMaper();
        services.addConference(maper.DTOinConference(conferenceDTO));
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
