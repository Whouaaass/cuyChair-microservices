package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.cuychair.conference_microservice.data_access.ConferenceRepository;
import co.edu.unicauca.cuychair.conference_microservice.data_access.PaperRepository;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.Conference;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.Paper;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.PaperDTO;

/**
 * Implementación de los servicios de paper
 * @author Frdy
 */
@Service
public class PaperServiceImpl implements IPaperService {

    private final PaperRepository paperRepository;
    private final ConferenceRepository conferenceRepository;
    private final ModelMapper modelMapper;

    public PaperServiceImpl(PaperRepository paperRepo, ConferenceRepository conferenceRepo, ModelMapper modelMapper) {
        this.paperRepository = paperRepo;
        this.conferenceRepository = conferenceRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PaperDTO> findAll() {
        List<Paper> papers = this.paperRepository.getAllPapers();        
        return this.modelMapper.map(papers, new TypeToken<List<PaperDTO>>() {}.getType());
    }

    @Override
    public PaperDTO findById(Integer id) {
        Paper paper = this.paperRepository.getPaperById(id);
        return this.modelMapper.map(paper, PaperDTO.class);
    }

    @Override
    public PaperDTO save(PaperDTO paper) {
        Paper paperEntity = this.modelMapper.map(paper, Paper.class);
        Paper paperSaved = this.paperRepository.addPaper(paperEntity);
        return this.modelMapper.map(paperSaved, PaperDTO.class);
    }

    @Override
    public PaperDTO update(Integer id, PaperDTO paper) {
        Paper paperEntity = this.modelMapper.map(paper, Paper.class);
        Paper paperUpdated = this.paperRepository.updatePaper(id, paperEntity);
        return this.modelMapper.map(paperUpdated, PaperDTO.class);
    }

    @Override
    public List<PaperDTO> findByConferenceId(Integer id) {
        Conference conference = this.conferenceRepository.getConferenceById(id);        
        return this.modelMapper.map(conference.getPapers(), new TypeToken<List<PaperDTO>>() {}.getType());
    } 

    @Override
    public boolean delete(Integer id) {
        return this.paperRepository.deletePaper(id) != null;
    }
   
    
}
