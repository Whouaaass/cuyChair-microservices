package co.edu.unicauca.cuychair.conference_microservice.services_layer.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.Conference;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.SimpleConferenceDTO;

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
        modelMapper.createTypeMap(SimpleConferenceDTO.class, Conference.class)
                .addMapping(SimpleConferenceDTO::getTitle, Conference::setName);
        modelMapper.createTypeMap(Conference.class, SimpleConferenceDTO.class)
                .addMapping(Conference::getName, SimpleConferenceDTO::setTitle)
                .addMapping(Conference::getChairId, SimpleConferenceDTO::setOwnerId);
    }
}
