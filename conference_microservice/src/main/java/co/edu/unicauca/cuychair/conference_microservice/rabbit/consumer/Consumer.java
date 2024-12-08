package co.edu.unicauca.cuychair.conference_microservice.rabbit.consumer;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO.AMPQConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO.AMPQUserDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.UserDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.services.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IUserService userService;

	@RabbitListener(queues = { "${cuychair.rabbitmq.queue.user.conference}" })
	public void receiveUserDTO(@Payload AMPQUserDTO userDTO) {
		log.info("Received message {} User name: {}", userDTO, userDTO.getName());
		UserDTO user = modelMapper.map(userDTO, UserDTO.class);

		UserDTO savedUser = userService.save(user);

		log.info("User saved: {}", savedUser);
		makeSlow();
	}

	@RabbitListener(queues = { "${cuychair.rabbitmq.queue.conference.conference}" })
	public void ReceiveConferenceDTO(@Payload AMPQConferenceDTO conferenceDTO) {
		log.info("Received message {} Conference name: {}", conferenceDTO, conferenceDTO.getTitle());
		makeSlow();
	}

	private void makeSlow() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
	}
}