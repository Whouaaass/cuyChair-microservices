package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.rabbit;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServiceUserPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.dto.UserDTO;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.maper.UserDTOMaper;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.User;

@Component
@Slf4j
public class UserLisenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(UserLisenerAdapter.class);

    @Autowired
    private ServiceUserPort services;

    @RabbitListener(queues = { "${cuychair.rabbitmq.queue.user.review}" })
    public void listenUser(@Payload UserDTO userDTO) {

        UserDTOMaper maper = new UserDTOMaper();        

        User userOld = services.findById(userDTO.getId());
        User usNew = maper.toUser(userDTO);
        if (userOld != null) {
            if(isEquals(userOld,usNew)){
                services.removeUser(usNew);
                return;
            }
            services.updateUser(usNew);
            return;
        }
        services.addUser(usNew);
        System.out.println("Recibido");
        makeSlow();
    }

    private boolean isEquals(User us1,User us2){
        return us1.getName().equals(us2.getName())
                && us1.getPhone() == us2.getPhone()
                && us1.getLastName().equals(us2.getLastName())
                && us1.getDescription().equals(us2.getDescription());
    }

    private void makeSlow() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("Thread was interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
