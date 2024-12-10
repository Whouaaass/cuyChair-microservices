package co.edu.unicauca.cuychair.paper_microservice.Paper;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.IRepositoryPaper;
import co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys.RepositoryPaper;
import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.rabbit.publisher.Publisher;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.PaperStoreService;

/*
* Para realizar los test por favor ir a PaperStoreService y poner como comentario las lineas 80,62 y 47
* */
public class ServicePaperTest {

    private IRepositoryPaper repository;
    private PaperStoreService service;
    private Conference conference;
    private User user;

    public void setUp() {
        user = new User(164, "Carlito ", "Fuentes", "juanmoran@unicauca.edu.co", "drg", "reg", 123);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        conference = new Conference(123, "Critica a las empanadas",
                "Las mejores cirticas hacia las empanadas conteporaneas",
                new Date().toString(),
                users,
                users,
                user);
        repository = new RepositoryPaper();
        Publisher publisher = new Publisher();
        service = new PaperStoreService(repository, publisher);
    }

    @Test
    public void testSavePaper() {
        setUp();
        Paper paper = new Paper(12, "Los tamales de maria", "Los tamales de maria son los mejores", "No se", user,
                conference);
        service.storePaper(paper);
        assertEquals(paper.getTitle(), service.listPapers().getFirst().getTitle());
    }

    @Test
    public void testDelatePaper() {
        setUp();
        Paper paper = new Paper(0, "Los tamales de maria", "Los tamales de maria son los mejores", "No se", user,
                conference);
        service.storePaper(paper);
        assertEquals(paper.getTitle(), service.delatePaper(paper).getTitle());
        assertTrue(service.listPapers().isEmpty());
    }

    @Test
    public void testEditPaper() {
        setUp();
        Paper paper1 = new Paper(0, "Los tamales de maria", "Los tamales de maria son los mejores", "No se", user,
                conference);
        Paper paper2 = new Paper(0, "Los grandes tamales de maria", "Los tamales grandes son los mejores", "No se",
                user, conference);
        service.storePaper(paper1);
        service.editPaper(paper2);
        assertEquals(paper2.getTitle(), service.listPapers().getFirst().getTitle());
        assertEquals(paper2.getAbstract(), service.listPapers().getFirst().getAbstract());
    }

    @Test
    public void testListPaper() {
        setUp();
        Paper paper = new Paper(12, "Los tamales de maria", "Los tamales de maria son los mejores", "No se", user,
                conference);
        service.storePaper(paper);
        assertNotNull(service.listPapers());
    }

    @Test
    public void testPapersAuthor() {
        setUp();
        Paper paper1 = new Paper(12, "Los tamales de maria", "Los tamales de maria son los mejores", "No se", user,
                conference);
        Paper paper2 = new Paper(12, "Los almuerzos de Juan", "Juan cocina las mejores Papitas", "No se", user,
                conference);
        service.storePaper(paper1);
        service.storePaper(paper2);
        assertEquals(paper1.getTitle(), service.getPaperByAuthor(164).getFirst().getTitle());
        assertEquals(paper2.getTitle(), service.getPaperByAuthor(164).getLast().getTitle());
    }
}
