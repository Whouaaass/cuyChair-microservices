package co.edu.unicauca.cuychair.conference_microservice.data_access;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.Paper;

@Repository
public class PaperRepository {
    private final List<Paper> paperlist;
    private final AtomicInteger idCounter;
    
    public PaperRepository() {
        this.paperlist = new ArrayList<>();
        this.idCounter = new AtomicInteger(1);
        addTestRegisters();
    }

    /**
     * Retorna todos los papers
     * @return
     */
    public List<Paper> getAllPapers() {
        return paperlist;
    }

    /**
     * Retorna un paper dado un id
     * @param id
     * @return
     */
    public Paper getPaperById(int id) {
        for (Paper paper : paperlist) {
            if (paper.getId().equals(id)) {
                return paper;
            }
        }
        return null;
    }

    /**
     * Añade un paper
     * @param paper
     * @return
     */
    public Paper addPaper(Paper paper) {
        paper.setId(idCounter.getAndIncrement());
        paperlist.add(paper);
        return paper;
    }

    /**
     * Actualiza un paper
     * @param paperId 
     * @param paper
     * @return
     */
    public Paper updatePaper(Integer paperId, Paper paper) {
        for (Paper p : paperlist) {
            if (p.getId().equals(paperId)) {
                p.setTitle(paper.getTitle());
                p.setSubtitle(paper.getSubtitle());
                p.setAbstract(paper.getAbstract());                
                return p;
            }
        }
        return null;
    }

    /**
     * Elimina un paper
     * @param paperId
     */
    public Paper deletePaper(Integer paperId) {
        for (Paper p : paperlist) {
            if (p.getId().equals(paperId)) {                
                paperlist.remove(p);
                return p;
            }
        }
        return null;
    }

    final public void addTestRegisters() {
        addPaper(new Paper(1, "Anatomia de los sapos", "El sapo que no sabia morir", "Habia un sapo que no sabia morir y nunca murio"));
        addPaper(new Paper(2, "Libreta de libelulas", "El magnetismo de las alas", "No se encontro magnetismo en las alas de las libelulas, pero si en sus ojos"));
        addPaper(new Paper(3, "El arte de la guerra", "La guerra de los gatos", "Los gatos se enfrentan en una guerra sin cuartel"));
    }
}
