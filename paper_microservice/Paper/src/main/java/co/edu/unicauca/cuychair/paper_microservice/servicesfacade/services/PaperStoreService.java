package co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services;

import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryConference;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryPaper;
import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryUser;
import co.edu.unicauca.cuychair.paper_microservice.email.ConfirmDeleateBuilder;
import co.edu.unicauca.cuychair.paper_microservice.email.ConfirmEditBuilder;
import co.edu.unicauca.cuychair.paper_microservice.email.ConfirmSendBuilder;
import co.edu.unicauca.cuychair.paper_microservice.email.DirectorSendEmail;
import co.edu.unicauca.cuychair.paper_microservice.rabbit.publisher.Publisher;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorPaperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaperStoreService {
    private final IRepositoryPaper repositoryPaper;
    private final Publisher publisher;
    private DirectorSendEmail directorSendEmail;

    @Autowired
    @Lazy
    private PaperStoreService self;


    public PaperStoreService(IRepositoryPaper repositoryPaper, Publisher publisher) {
        this.repositoryPaper = repositoryPaper;
        this.publisher = publisher;
    }



    public void sendPaperDTORabbit(Paper paper) {
        publisher.sendPaperDTO(paper);
    }

    @Async
    public void sendEmail(){
        directorSendEmail.buildAndSend();
    }

    public void UseSendEmail(){
        self.sendEmail();
    }
    /**
     * @brief Guardar un Paper
     * @param objPaper Paper a guardar
     * @return Confirmación
     */
    public Paper storePaper (Paper objPaper){
        Paper paper=repositoryPaper.storePaper(objPaper);
        this.directorSendEmail=new DirectorSendEmail(new ConfirmSendBuilder(),paper);
        if(paper==null) {
            return null;
        }
        sendPaperDTORabbit(paper);
        UseSendEmail();
        return objPaper;
    }
    /**
     * @brief Eliminar un Paper
     * @param objPaper Paper a eliminar
     * @return Paper eliminado
     */

    public Paper delatePaper (Paper objPaper){
        this.directorSendEmail=new DirectorSendEmail(new ConfirmDeleateBuilder(),objPaper);
        if(repositoryPaper.delatePaper(objPaper)==null) {
            return null;
        }
        sendPaperDTORabbit(objPaper);
        UseSendEmail();
        return objPaper;
    }

    /**
     * @brief listar los Paper
     * @return lista de todos los paper
     */
    public List<Paper> listPapers (){
        return repositoryPaper.listPapers();
    }

    public Paper editPaper(Paper objPaper){
        this.directorSendEmail=new DirectorSendEmail(new ConfirmEditBuilder(),objPaper);
        if(repositoryPaper.editPaper(objPaper)==null) {
            return null;
        }
        sendPaperDTORabbit(objPaper);
        UseSendEmail();
        return objPaper;
    }

    public List<Paper> getPaperByAuthor(int authorId){
        return repositoryPaper.getPapersByAuthor(authorId);
    }

    public Paper clonePaper(int paperId)  {
        try{
            Paper paperPrototype=repositoryPaper.existPaper(paperId);
            if(paperPrototype!=null) {
                return paperPrototype.clone();
            }
        }catch (CloneNotSupportedException e){
            return null;
        }
        return null;
    }
}
