package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper;

import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryUser;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.PaperDTO;

import java.util.ArrayList;
import java.util.List;

public class ConversorPaperDTO {
    IRepositoryConference repositoryConference;
    IRepositoryUser repositoryUser;

    public ConversorPaperDTO(IRepositoryUser repositoryUser, IRepositoryConference repositoryConference) {
        this.repositoryUser = repositoryUser;
        this.repositoryConference = repositoryConference;
    }

    public PaperDTO PaperinDTO (Paper paper){
        return new PaperDTO(paper.getId(), paper.getTitle(), paper.getAbstract(), paper.getSubtitle(), paper.getAuthor().getId(),paper.getConference().getId());
    }

    public Paper DTOinPaper(PaperDTO paperDTO){
        return new Paper(paperDTO.getId(), paperDTO.getTitle(), paperDTO.getAbstract(), paperDTO.getSubTitle(), repositoryUser.getUserById(paperDTO.getIdAuthor()),repositoryConference.getConferenceById(paperDTO.getIdConference()));
    }


    public List<PaperDTO> listPaperinDTO(List<Paper> papers){
        List<PaperDTO> paperDTOs = new ArrayList<>();
        for(Paper paper : papers){
            paperDTOs.add(PaperinDTO(paper));
        }
        return paperDTOs;
    }


}
