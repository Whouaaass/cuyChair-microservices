package co.edu.unicauca.cuychair.conference_microservice.rabbit.consumer;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO.AMPQUserDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.UserDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.services.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

	@Autowired
	private ModelMapper	modelMapper;

	@Autowired
	private IUserService userService;

	@RabbitListener(queues = { "${co.edu.unicauca.cuychair.user.conference.queue}" })
	public void receiveUserDTO(@Payload AMPQUserDTO userDTO) {
		log.info("Received message {} User name: {}", userDTO, userDTO.getName());
		UserDTO user = modelMapper.map(userDTO, UserDTO.class);

		UserDTO savedUser = userService.save(user);			

		log.info("User saved: {}", savedUser);
		
		makeSlow();
	}

	private void makeSlow() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) { }
	}
}