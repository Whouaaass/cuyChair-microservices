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
import co.edu.unicauca.cuychair.conference_microservice.rabbit.DTO.AMPQConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.rabbit.publisher.Publisher;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.PostConferenceDTO;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.UserDTO;

/**
 * Implementación de los servicios de conferencia
 * @author Frdy
 */
@Service
public class ConferenceServiceImpl implements IConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final PaperRepository paperRepository;
    private final UserRepository userRepository;
    private final Publisher AMPQPublisher;

    private final ModelMapper modelMapper;

    public ConferenceServiceImpl(ConferenceRepository conferenceRepository, PaperRepository paperRepository, UserRepository userRepository, ModelMapper modelMapper, Publisher publisher) {
        this.conferenceRepository = conferenceRepository;
        this.userRepository = userRepository;
        this.paperRepository = paperRepository;
        this.modelMapper = modelMapper;   
        this.AMPQPublisher = publisher;     
    }

    @Override
    public List<ConferenceDTO> findAll() {
        List<Conference> conferences = this.conferenceRepository.getAllConferences();
        return this.modelMapper.map(conferences, new TypeToken<List<ConferenceDTO>>() {}.getType());
    }

    @Override
    public ConferenceDTO findById(Integer id) {
        Conference conference = this.conferenceRepository.getConferenceById(id);
        return this.modelMapper.map(conference, ConferenceDTO.class);
        
    }

    @Override
    public ConferenceDTO save(PostConferenceDTO conference) {        
        Conference conferenceEntity = this.modelMapper.map(conference, Conference.class);        
        User owner = this.userRepository.getUserById(conference.getOwnerId());
        System.out.println(conference.getOwnerId());        
        conferenceEntity.setChair(owner);
        Conference conferenceSaved = this.conferenceRepository.addConference(conferenceEntity);
        if (conferenceSaved != null) {
            PublishConference(conferenceSaved);
        }
        return this.modelMapper.map(conferenceSaved, ConferenceDTO.class);
    }

    @Override
    public ConferenceDTO update(Integer id, ConferenceDTO conference) {
        Conference conferenceEntity = this.modelMapper.map(conference, Conference.class);
        Conference conferenceUpdated = this.conferenceRepository.updateConference(id, conferenceEntity);
        if (conferenceEntity != null) {
            ConferenceDTO conferenceDTO = conferenceToDTO(conferenceUpdated);                        
            PublishConference(conferenceEntity);
            return conferenceDTO;
        }        
        return null;        
    }


    @Override
    public ConferenceDTO AddAuthor(Integer conferenceId, Integer userId) {
        Conference conference = this.conferenceRepository.getConferenceById(conferenceId);
        User user = this.userRepository.getUserById(userId);
        boolean flag =  ConferenceRelations.addAuthor(conference, user);  
        if (flag) {
            ConferenceDTO conferenceDTO = conferenceToDTO(conference);

            PublishConference(conference);            
            return conferenceDTO;
        }
        return null;        
    }

    @Override
    public ConferenceDTO AddReviewer(Integer conferenceId, Integer userId) {
        Conference conference = this.conferenceRepository.getConferenceById(conferenceId);
        User user = this.userRepository.getUserById(userId);
        boolean flag = ConferenceRelations.addReviewer(conference, user);        
        if (flag) {
            ConferenceDTO conferenceDTO = conferenceToDTO(conference);
            
            PublishConference(conference);
            return conferenceDTO;
        }
        return null;        
    }

    @Override
    public ConferenceDTO AddPaper(Integer conferenceId, Integer paperId) {
        Conference conference = this.conferenceRepository.getConferenceById(conferenceId);
        Paper paper = this.paperRepository.getPaperById(paperId);
        boolean flag = ConferenceRelations.addPaper(conference, paper);
        if (flag) {
            ConferenceDTO conferenceDTO = conferenceToDTO(conference);
            
            PublishConference(conference);
            return conferenceDTO;
        }
        return null;        
    }    

    @Override
    public boolean delete(Integer id) {
        return this.conferenceRepository.deleteConference(id) != null;
    }

    private ConferenceDTO conferenceToDTO(Conference conference) {
        ConferenceDTO conferenceDTO = this.modelMapper.map(conference, ConferenceDTO.class);
        conferenceDTO.setReviewers(modelMapper.map(conference.getReviewers(), new TypeToken<List<UserDTO>>() {}.getType()));
        conferenceDTO.setAuthors(modelMapper.map(conference.getAuthors(), new TypeToken<List<UserDTO>>() {}.getType()));        
        return conferenceDTO;
    }

    private void PublishConference(Conference conference) {
        AMPQConferenceDTO conferenceDTO = this.modelMapper.map(conference, AMPQConferenceDTO.class);
        conferenceDTO.setAuthorIds(List.of(conference.getAuthors().stream().map(User::getId).toArray(Integer[]::new)));
        conferenceDTO.setReviewerIds(List.of(conference.getReviewers().stream().map(User::getId).toArray(Integer[]::new)));
        this.AMPQPublisher.publishConference(conferenceDTO);        
    }

    
}
