package co.edu.unicauca.cuychair.paper_microservice.Paper;

import co.edu.unicauca.cuychair.paper_microservice.dataacces.IRepositoryPaper;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.RepositoryPaper;
import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.services.PaperStoreService;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ServicePaperTest {

    private IRepositoryPaper repository;
    private PaperStoreService service;
    private Paper paper;

    public void setUp(){
        repository=new RepositoryPaper();
        service=new PaperStoreService(repository);
        paper=new Paper();
        User author=new User();
        Conference conference=new Conference();
        paper.setTitle("Matemáticas");
        paper.setDescription("Lo mejor de las matemáticas");
        paper.setAuthor(author);
        paper.setConference(conference);
    }

    @Test
    public void testSavePaper (){
        setUp();
        service.storePaper(paper);
        assertEquals(paper.getTitle(),service.listPapers().getFirst().getTitle());
    }

    @Test
    public void testDelatePaper(){
        setUp();
        service.storePaper(paper);
        service.delatePaper(paper);
        assertTrue(service.listPapers().isEmpty());
    }

    @Test
    public void testListPaper(){
        setUp();
        service.storePaper(paper);
        assertNotNull(service.listPapers());
    }
}
