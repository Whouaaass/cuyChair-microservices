package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.rabbit;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServiceConferencePort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServiceUserPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Conference;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.User;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.dto.ConferenceDTO;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.maper.ConferenceDTOMaper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Slf4j
public class ConferenceLisenerAdapter {

    private final ServiceConferencePort services;
    private final ServiceUserPort serviceUsers;

    public ConferenceLisenerAdapter(ServiceConferencePort services,ServiceUserPort serviceUsers) {
        this.services = services;
        this.serviceUsers = serviceUsers;
    }
    @RabbitListener(queues = { "${cuychair.rabbitmq.queue.conference.review}" })
    public void listenConference(@Payload ConferenceDTO conferenceDTO) {
        ConferenceDTOMaper maper = new ConferenceDTOMaper();
        ArrayList<User> authors=new ArrayList<>();
        ArrayList<User> reviwers=new ArrayList<>();
        for(int id: conferenceDTO.getReviewerIds()){
            authors.add(serviceUsers.findById(id));
        }
        for(int id: conferenceDTO.getAuthorIds()){
            reviwers.add(serviceUsers.findById(id));
        }
        Conference confeOld=services.findById(conferenceDTO.getId());
        Conference confeNew=maper.DTOinConference(conferenceDTO,authors,reviwers,serviceUsers.findById(conferenceDTO.getOwnerId()));
        if(confeOld!=null){
            if(isEquals(confeOld,confeNew)){
                services.removeConference(confeNew);
                return;
            }
            services.updateConference(confeNew);
            System.out.println("Recibido");
            return;
        }
        services.addConference(confeNew);
        System.out.println("Recibido");
        makeSlow();
    }

    private boolean isEquals(Conference objConference1, Conference objConference2) {
        return objConference1.getTitle().equals(objConference2.getTitle()) && objConference1.getDate().equals(objConference2.getDate())
                && objConference1.getReviewers().size() == objConference2.getReviewers().size()
                && objConference1.getAuthors().size() == objConference2.getAuthors().size();
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
