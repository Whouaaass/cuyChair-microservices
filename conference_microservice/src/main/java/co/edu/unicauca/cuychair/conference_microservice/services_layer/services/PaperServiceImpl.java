package co.edu.unicauca.cuychair.conference_microservice.services_layer.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.cuychair.conference_microservice.data_access.PaperRepository;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.Paper;
import co.edu.unicauca.cuychair.conference_microservice.services_layer.DTO.PaperDTO;

/**
 * Implementación de los servicios de paper
 * @author Frdy
 */
@Service
public class PaperServiceImpl implements IPaperService {

    private final PaperRepository repository;
    private final ModelMapper modelMapper;

    public PaperServiceImpl(PaperRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PaperDTO> findAll() {
        List<Paper> papers = this.repository.getAllPapers();        
        return this.modelMapper.map(papers, new TypeToken<List<PaperDTO>>() {}.getType());
    }

    @Override
    public PaperDTO findById(Integer id) {
        Paper paper = this.repository.getPaperById(id);
        return this.modelMapper.map(paper, PaperDTO.class);
    }

    @Override
    public PaperDTO save(PaperDTO paper) {
        Paper paperEntity = this.modelMapper.map(paper, Paper.class);
        Paper paperSaved = this.repository.addPaper(paperEntity);
        return this.modelMapper.map(paperSaved, PaperDTO.class);
    }

    @Override
    public PaperDTO update(Integer id, PaperDTO paper) {
        Paper paperEntity = this.modelMapper.map(paper, Paper.class);
        Paper paperUpdated = this.repository.updatePaper(id, paperEntity);
        return this.modelMapper.map(paperUpdated, PaperDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        return this.repository.deletePaper(id) != null;
    }
   
    
}
