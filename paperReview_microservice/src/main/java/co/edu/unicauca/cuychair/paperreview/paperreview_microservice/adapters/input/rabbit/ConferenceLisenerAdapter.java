package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.rabbit;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.dto.ConferenceDTO;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.maper.ConferenceDTOMaper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input.ServiceConferencePort;
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
    @RabbitListener(queues = { "${co.edu.unicauca.cuychair.user.conferenceDTO.queue}" })
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
