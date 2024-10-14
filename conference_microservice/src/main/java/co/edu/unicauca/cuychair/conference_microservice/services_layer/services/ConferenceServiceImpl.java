package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.cuychair.conference_microservice.data_access.ConferenceRepository;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.Conference;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ConferenceDTO;

/**
 * Implementación de los servicios de conferencia
 * @author Frdy
 */
@Service
public class ConferenceServiceImpl implements IConferenceService {

    private ConferenceRepository repository;
    private final ModelMapper modelMapper;

    public ConferenceServiceImpl(ConferenceRepository conferenceRepository, ModelMapper modelMapper) {
        this.repository = conferenceRepository;
        this.modelMapper = modelMapper;        
    }

    @Override
    public List<ConferenceDTO> findAll() {
        List<Conference> conferences = this.repository.getAllConferences();
        return this.modelMapper.map(conferences, new TypeToken<List<ConferenceDTO>>() {}.getType());
    }

    @Override
    public ConferenceDTO findById(Integer id) {
        Conference conference = this.repository.getConferenceById(id);
        return this.modelMapper.map(conference, ConferenceDTO.class);
        
    }

    @Override
    public ConferenceDTO save(ConferenceDTO conference) {
        Conference conferenceEntity = this.modelMapper.map(conference, Conference.class);
        Conference conferenceSaved = this.repository.addConference(conferenceEntity);
        return this.modelMapper.map(conferenceSaved, ConferenceDTO.class);
    }

    @Override
    public ConferenceDTO update(Integer id, ConferenceDTO conference) {
        Conference conferenceEntity = this.modelMapper.map(conference, Conference.class);
        Conference conferenceUpdated = this.repository.updateConference(id, conferenceEntity);
        return this.modelMapper.map(conferenceUpdated, ConferenceDTO.class);        
    }

    @Override
    public boolean delete(Integer id) {
        return this.repository.deleteConference(id) != null;
    }

    
}
