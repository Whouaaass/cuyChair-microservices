package co.edu.unicauca.cuychair.conference_microservice.services_layer.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.Conference;
import co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO.AMPQConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO.AMPQUserDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.PostConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.UserDTO;

@Configuration
public class mapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        conferenceConfig(modelMapper);
        return modelMapper;
    }

    /**
     * Configura el mapper para las Conferencias
     * 
     * @param modelMapper mapper
     */
    public void conferenceConfig(ModelMapper modelMapper) {
        // ConferenceDTO                
        modelMapper.createTypeMap(ConferenceDTO.class, Conference.class)
                .addMapping(ConferenceDTO::getTitle, Conference::setName);
        modelMapper.createTypeMap(Conference.class, ConferenceDTO.class)
                .addMapping(Conference::getName, ConferenceDTO::setTitle)
                .addMapping(Conference::getChair, ConferenceDTO::setOwner);
                

        // SimpleConferenceDTO
        modelMapper.createTypeMap(PostConferenceDTO.class, Conference.class)
                .addMapping(PostConferenceDTO::getTitle, Conference::setName);
        modelMapper.createTypeMap(Conference.class, PostConferenceDTO.class)
                .addMapping(Conference::getName, PostConferenceDTO::setTitle)
                .addMapping(Conference::getChairId, PostConferenceDTO::setOwnerId);

        // Conference -> AMPQConferenceDTO
        modelMapper.createTypeMap(Conference.class, AMPQConferenceDTO.class)
                .addMapping(Conference::getName, AMPQConferenceDTO::setTitle)
                .addMapping(Conference::getChairId, AMPQConferenceDTO::setOwnerId);
        
    }

    /**
     * Configura el mapper para los Usuarios
     * @param modelMapper
     */
    public void userConfig(ModelMapper modelMapper) {
        // UserDTO <-> AMPQUserDTO
        modelMapper.createTypeMap(AMPQUserDTO.class, UserDTO.class)
                .addMapping(AMPQUserDTO::getLastName, UserDTO::setLastname);
    }
        

    
}
