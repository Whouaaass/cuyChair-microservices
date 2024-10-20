package co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryPaper;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryUser;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.services.ConferenceStoreService;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.services.PaperStoreService;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.services.UserStoreService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ConversorPaperDTO {
    IRepositoryConference repositoryConference;
    IRepositoryUser repositoryUser;

    public ConversorPaperDTO(IRepositoryUser repositoryUser, IRepositoryConference repositoryConference) {
        this.repositoryUser = repositoryUser;
        this.repositoryConference = repositoryConference;
    }

    public PaperDTO PaperinDTO (Paper paper){
        return new PaperDTO(paper.getId(), paper.getTitle(), paper.getDescription(), paper.getAuthor().getId(),paper.getConference().getId());
    }

    public Paper DTOinPaper(PaperDTO paperDTO){
        return new Paper(paperDTO.getId(), paperDTO.getTitle(), paperDTO.getDescription(), repositoryUser.getUserById(paperDTO.getIdAuthor()),repositoryConference.getConferenceById(paperDTO.getIdConference()));
    }

    /*
    public List<PaperDTO> listPaperinDTO(List<Paper> papers){
        return modelMapper.map(papers, new TypeToken<List<PaperDTO>>() {}.getType());
    }
    */

}
