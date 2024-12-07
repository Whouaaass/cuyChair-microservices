package co.edu.unicauca.cuychair.paper_microservice.controller.mapper;

import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryUser;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;

import java.util.ArrayList;
import java.util.List;

public class ConversorPaperDTO {

    public PaperDTO toPaperDTO(Paper paper){
        return new PaperDTO(paper.getId(), paper.getTitle(), paper.getAbstract(), paper.getSubtitle(), paper.getAuthor().getId(),paper.getConference().getId());
    }

    public Paper toPaper(PaperDTO paperDTO, User author, Conference conference){
        return new Paper(paperDTO.getId(), paperDTO.getTitle(), paperDTO.getAbstract(), paperDTO.getSubTitle(),author,conference);
    }


    public List<PaperDTO> toPaperDTOList(List<Paper> papers){
        List<PaperDTO> paperDTOs = new ArrayList<>();
        for(Paper paper : papers){
            paperDTOs.add(toPaperDTO(paper));
        }
        return paperDTOs;
    }


}
