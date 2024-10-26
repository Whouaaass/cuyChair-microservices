package co.edu.unicauca.cuychair.paper_microservice.layerservices.services;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryPaper;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys.IRepositoryUser;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper.ConversorPaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper.ConversorUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaperStoreService {
    IRepositoryPaper repositoryPaper;
    IRepositoryUser repositoryUser;
    IRepositoryConference repositoryConference;
    ConversorPaperDTO map;
    ConversorUserDTO mapUser;

    @Autowired
    public PaperStoreService(IRepositoryPaper repositoryPaper, IRepositoryUser repositoryUser, IRepositoryConference repositoryConference) {
        this.repositoryPaper = repositoryPaper;
        this.repositoryUser = repositoryUser;
        this.repositoryConference = repositoryConference;
        map=new ConversorPaperDTO(repositoryUser,repositoryConference);
    }

    /**
     * @brief Guardar un Paper
     * @param objPaper Paper a guardar
     * @return Confirmación
     */
    public boolean storePaper (PaperDTO objPaper){
        return repositoryPaper.storePaper(map.DTOinPaper(objPaper));
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
