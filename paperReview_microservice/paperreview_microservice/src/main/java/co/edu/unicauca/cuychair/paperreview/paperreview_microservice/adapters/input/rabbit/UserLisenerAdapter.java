package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.rabbit;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.dto.UserDTO;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input.maper.UserDTOMaper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input.ServiceUserPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserLisenerAdapter {
    private final ServiceUserPort services;


    public UserLisenerAdapter(ServiceUserPort services) {
        this.services = services;
    }

    @RabbitListener(queues = { "${co.edu.unicauca.cuychair.user.userDTO.queue}" })
    public void listenUser(@Payload UserDTO userDTO) {
        UserDTOMaper maper = new UserDTOMaper();
        services.addUser(maper.toUser(userDTO));
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
