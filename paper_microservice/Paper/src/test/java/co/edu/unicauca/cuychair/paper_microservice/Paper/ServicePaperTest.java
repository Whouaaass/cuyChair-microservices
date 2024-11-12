package co.edu.unicauca.cuychair.paper_microservice.Paper;

import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.*;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.rabbit.publisher.Publisher;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.PaperStoreService;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ServicePaperTest {

    private IRepositoryPaper repository;
    private IRepositoryConference repositoryConference;
    private IRepositoryUser repositoryUser;
    private PaperStoreService service;
    private Conference conference;
    private User user;

    public void setUp(){
        user = new User(164,"Carlito Fuentes","carlitos@gmail.com","db","drg","reg",123);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        conference = new Conference(123,"Critica a las empanadas","Las mejores cirticas hacia las empanadas conteporaneas",new Date(),users,users ,user);
        repository=new RepositoryPaper();
        repositoryConference=new RepositoryConference();
        repositoryUser=new RepositoryUser();
        repositoryConference.addConference(conference);
        repositoryUser.addUser(user);
        Publisher publisher=new Publisher();
        service=new PaperStoreService(repository,repositoryUser,repositoryConference,publisher);
    }

    @Test
    public void testSavePaper (){
        setUp();
        PaperDTO paperDTO=new PaperDTO(12,"Los tamales de maria","Los tamales de maria son los mejores","No se",164,123);
        service.storePaper(paperDTO);
        assertEquals(paperDTO.getTitle(),service.listPapers().getFirst().getTitle());
    }

    @Test
    public void testDelatePaper(){
        setUp();
        PaperDTO paperDTO=new PaperDTO(0,"Los tamales de maria","Los tamales de maria son los mejores","No se",164,123);
        service.storePaper(paperDTO);
        service.delatePaper(paperDTO);
        assertTrue(service.listPapers().isEmpty());
    }

    @Test
    public void testEditPaper(){
        setUp();
        PaperDTO paperDTO=new PaperDTO(0,"Los tamales de maria","Los tamales de maria son los mejores","No se",164,123);
        PaperDTO paperDTO2=new PaperDTO(0,"Los grandes tamales de maria","Los tamales grandes son los mejores","No se",164,123);
        service.storePaper(paperDTO);
        service.editPaper(paperDTO2);
        assertEquals(paperDTO2.getTitle(),service.listPapers().getFirst().getTitle());
        assertEquals(paperDTO2.getAbstract(),service.listPapers().getFirst().getAbstract());
    }

    @Test
    public void testListPaper(){
        setUp();
        PaperDTO paperDTO=new PaperDTO(12,"Los tamales de maria","Los tamales de maria son los mejores","No se",164,123);
        service.storePaper(paperDTO);
        assertNotNull(service.listPapers());
    }

    @Test
    public void testPapersAuthor(){
        setUp();
        PaperDTO paperDTO=new PaperDTO(12,"Los tamales de maria","Los tamales de maria son los mejores","No se",164,123);
        PaperDTO paperDTO2=new PaperDTO(12,"Los almuerzos de Juan","Juan cocina las mejores Papitas","No se",164,123);
        service.storePaper(paperDTO);
        service.storePaper(paperDTO2);
        assertEquals(paperDTO.getTitle(),service.getPaperByAuthor(164).getFirst().getTitle());
        assertEquals(paperDTO2.getTitle(),service.getPaperByAuthor(164).getLast().getTitle());
    }
}
