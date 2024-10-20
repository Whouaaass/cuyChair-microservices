package co.edu.unicauca.cuychair.user.user_microservice.consumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

	@RabbitListener(queues = { "${co.edu.unicauca.cuychair.user.userDTO.queue}" })
	public void receiveUserDTO(@Payload UserDTO userDTO) {

		log.info("Received message {} User name: {}", userDTO, userDTO.getName());

		makeSlow();

	}
	

    @RabbitListener(queues = { "${co.edu.unicauca.cuychair.user.conferenceDTO.queue}" })
    public void receiveConferenceDTO(@Payload ConferenceDTO conferenceDTO) {

		log.info("Received message {} Conference title: {}", conferenceDTO, conferenceDTO.getTitle());
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