package co.edu.unicauca.cuychair.conference_microservice.data_access;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.Paper;

@Repository
public class PaperRepository {
    private final Map<Integer, Paper> papers;

    public PaperRepository() {
        this.papers = new HashMap<>();
        addTestRegisters();
    }

    /**
     * Retorna todos los papers
     * 
     * @return
     */
    public List<Paper> getAllPapers() {
        return List.copyOf(papers.values());
    }

    /**
     * Retorna un paper dado un id
     * 
     * @param id
     * @return
     */
    public Paper getPaperById(int id) {
        return papers.get(id);
    }

    /**
     * Añade un paper
     * 
     * @param paper
     * @return
     */
    public Paper addPaper(Paper paper) {
        return papers.put(paper.getId(), paper);
    }

    /**
     * Actualiza un paper
     * 
     * @param paperId
     * @param paper
     * @return
     */
    public Paper updatePaper(Integer paperId, Paper paper) {
        Paper p = papers.get(paperId);
        if (p == null)
            return null;
        p.setTitle(paper.getTitle());
        p.setSubtitle(paper.getSubtitle());
        p.setAbstract(paper.getAbstract());
        return p;

    }

    /**
     * Elimina un paper
     * 
     * @param paperId
     */
    public Paper deletePaper(Integer paperId) {
        return papers.remove(paperId);
    }

    final public void addTestRegisters() {
        addPaper(new Paper(1, "Anatomia de los sapos", "El sapo que no sabia morir",
                "Habia un sapo que no sabia morir y nunca murio"));
        addPaper(new Paper(2, "Libreta de libelulas", "El magnetismo de las alas",
                "No se encontro magnetismo en las alas de las libelulas, pero si en sus ojos"));
        addPaper(new Paper(3, "El arte de la guerra", "La guerra de los gatos",
                "Los gatos se enfrentan en una guerra sin cuartel"));
    }
}
