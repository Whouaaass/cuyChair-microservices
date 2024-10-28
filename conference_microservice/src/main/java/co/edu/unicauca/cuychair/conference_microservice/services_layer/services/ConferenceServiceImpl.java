package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.cuychair.conference_microservice.data_access.ConferenceRepository;
import co.edu.unicauca.cuychair.conference_microservice.data_access.PaperRepository;
import co.edu.unicauca.cuychair.conference_microservice.data_access.UserRepository;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.Conference;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.Paper;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.User;
import co.edu.unicauca.cuychair.conference_microservice.domain.services.ConferenceRelations;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.SimpleConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.UserDTO;

/**
 * Implementación de los servicios de conferencia
 * @author Frdy
 */
@Service
public class ConferenceServiceImpl implements IConferenceService {

    private final ConferenceRepository repository;
    private final PaperRepository paperRepository;
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public ConferenceServiceImpl(ConferenceRepository conferenceRepository, PaperRepository paperRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.repository = conferenceRepository;
        this.userRepository = userRepository;
        this.paperRepository = paperRepository;
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
    public ConferenceDTO save(SimpleConferenceDTO conference) {        
        Conference conferenceEntity = this.modelMapper.map(conference, Conference.class);        
        User owner = this.userRepository.getUserById(conference.getOwnerId());
        System.out.println(conference.getOwnerId());
        if (owner != null) System.out.println("Owner: " + owner.getId());
        conferenceEntity.setChair(owner);
        Conference conferenceSaved = this.repository.addConference(conferenceEntity);
        return this.modelMapper.map(conferenceSaved, ConferenceDTO.class);
    }

    @Override
    public ConferenceDTO update(Integer id, ConferenceDTO conference) {
        Conference conferenceEntity = this.modelMapper.map(conference, Conference.class);
        Conference conferenceUpdated = this.repository.updateConference(id, conferenceEntity);
        if (conferenceEntity != null) {
            ConferenceDTO conferenceDTO = this.modelMapper.map(conferenceUpdated, ConferenceDTO.class);
            conferenceDTO.setParticipantsList(this.modelMapper.map(conferenceUpdated.getParticipants(), new TypeToken<List<UserDTO>>() {}.getType()));
            return conferenceDTO;
        }
        return null;        
    }


    @Override
    public ConferenceDTO AddAuthor(Integer conferenceId, Integer userId) {
        Conference conference = this.repository.getConferenceById(conferenceId);
        User user = this.userRepository.getUserById(userId);
        boolean flag =  ConferenceRelations.addAuthor(conference, user);  
        if (flag) {
            ConferenceDTO conferenceDTO = this.modelMapper.map(conference, ConferenceDTO.class);
            System.out.println("donde se totea");
            conferenceDTO.setParticipantsList(this.modelMapper.map(conference.getParticipants(), new TypeToken<List<UserDTO>>() {}.getType()));
            System.out.println("no se toteó");
            return conferenceDTO;
        }
        return null;        
    }

    @Override
    public ConferenceDTO AddReviewer(Integer conferenceId, Integer userId) {
        Conference conference = this.repository.getConferenceById(conferenceId);
        User user = this.userRepository.getUserById(userId);
        boolean flag = ConferenceRelations.addReviewer(conference, user);        
        if (flag) {
            ConferenceDTO conferenceDTO = this.modelMapper.map(conference, ConferenceDTO.class);
            conferenceDTO.setParticipantsList(this.modelMapper.map(conference.getParticipants(), new TypeToken<List<UserDTO>>() {}.getType()));
            return conferenceDTO;
        }
        return null;        
    }

    @Override
    public ConferenceDTO AddPaper(Integer conferenceId, Integer paperId) {
        Conference conference = this.repository.getConferenceById(conferenceId);
        Paper paper = this.paperRepository.getPaperById(paperId);
        boolean flag = ConferenceRelations.addPaper(conference, paper);
        if (flag) {
            ConferenceDTO conferenceDTO = this.modelMapper.map(conference, ConferenceDTO.class);
            conferenceDTO.setParticipantsList(this.modelMapper.map(conference.getParticipants(), new TypeToken<List<UserDTO>>() {}.getType()));
            return conferenceDTO;
        }
        return null;        
    }    

    @Override
    public boolean delete(Integer id) {
        return this.repository.deleteConference(id) != null;
    }

    
}
