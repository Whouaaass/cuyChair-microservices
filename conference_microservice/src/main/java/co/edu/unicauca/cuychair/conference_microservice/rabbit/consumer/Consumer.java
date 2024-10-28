package co.edu.unicauca.cuychair.conference_microservice.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO.RabbitUserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

	@RabbitListener(queues = { "${co.edu.unicauca.cuychair.user.conference.queue}" })
	public void receiveUserDTO(@Payload RabbitUserDTO userDTO) {

		log.info("Received message {} User name: {}", userDTO, userDTO.getName());
		//registrar usuarioDTO
		makeSlow();

	}

	private void makeSlow() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) { }
	}
}