package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services;

import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryPaper;
import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryUser;
import co.edu.unicauca.cuychair.paper_microservice.publisher.Publisher;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.mapper.ConversorPaperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaperStoreService {
    private final IRepositoryPaper repositoryPaper;
    private final IRepositoryUser repositoryUser;
    private final IRepositoryConference repositoryConference;
    private final ConversorPaperDTO map;
    private final Publisher publisher;


    public PaperStoreService(IRepositoryPaper repositoryPaper, IRepositoryUser repositoryUser, IRepositoryConference repositoryConference,Publisher publisher) {
        this.repositoryPaper = repositoryPaper;
        this.repositoryUser = repositoryUser;
        this.repositoryConference = repositoryConference;
        map=new ConversorPaperDTO(repositoryUser,repositoryConference);
        this.publisher = publisher;
    }



    public void sendPaperDTORabbit(PaperDTO paperDTO) {
        publisher.sendPaperDTO(paperDTO);
    }

    /**
     * @brief Guardar un Paper
     * @param objPaper Paper a guardar
     * @return Confirmación
     */
    public boolean storePaper (PaperDTO objPaper){
        boolean status=repositoryPaper.storePaper(map.DTOinPaper(objPaper));
        if(status) {
            publisher.sendPaperDTO(objPaper);
        }
        return status;
    }
    /**
     * @brief Eliminar un Paper
     * @param objPaper Paper a eliminar
     * @return Paper eliminado
     */

    public boolean delatePaper (PaperDTO objPaper){
        return repositoryPaper.delatePaper(map.DTOinPaper(objPaper));
    }

    /**
     * @brief listar los Paper
     * @return lista de todos los paper
     */
    public List<Paper> listPapers (){
        return repositoryPaper.listPapers();
    }

    public PaperDTO editPaper(PaperDTO objPaper){
        return map.PaperinDTO(repositoryPaper.editPaper(map.DTOinPaper(objPaper)));
    }

    public List<PaperDTO> getPaperByAuthor(int authorId){
        return map.listPaperinDTO(repositoryPaper.getPapersByAuthor(authorId));
    }
}
