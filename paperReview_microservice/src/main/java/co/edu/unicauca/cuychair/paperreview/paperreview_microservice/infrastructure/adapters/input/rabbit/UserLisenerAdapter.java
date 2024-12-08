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

        User user = services.findById(userDTO.getId());

        if (user == null) {
            services.addUser(maper.toUser(userDTO));
            return;
        }

        UserDTO us = maper.toUserDTO(user);

        if (us.getName().equals(userDTO.getName())
                && us.getPhone() == userDTO.getPhone()
                && us.getLastName().equals(userDTO.getLastName())
                && us.getDescription().equals(userDTO.getDescription())) {
            services.removeUser(maper.toUser(userDTO));
        } else {
            services.updateUser(maper.toUser(userDTO));
        }

        makeSlow();

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
