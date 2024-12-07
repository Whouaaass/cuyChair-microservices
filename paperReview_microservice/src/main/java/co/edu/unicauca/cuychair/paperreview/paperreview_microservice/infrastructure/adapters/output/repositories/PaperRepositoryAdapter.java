package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.repositories;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.PaperEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper.PaperRepositoryMaper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.PaperRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Paper;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaperRepositoryAdapter implements PaperRepositoryPort {
    private List<PaperEntity> papers;
    private PaperRepositoryMaper maper;

    @Override
    public Paper addPaper(Paper paper) {
        if(papers == null) {
            this.papers = new ArrayList<>();
            this.maper = new PaperRepositoryMaper();
        }
        papers.add(maper.toPaperEntity(paper));
        return paper;
    }

    @Override
    public Paper updatePaper(Paper paper) {
        int index = papers.indexOf(maper.toPaperEntity(paper));
        if(index == -1) {
            return null;
        }
        papers.set(index,maper.toPaperEntity(paper));
        return paper;
    }

    @Override
    public Paper removePaper(Paper paper) {
        papers.remove(maper.toPaperEntity(paper));
        return paper;
    }

    @Override
    public Paper findById(int id) {
        for(PaperEntity paper : papers) {
            if(paper.getId() == id) {
                return maper.toPaper(paper);
            }
        }
        return null;
    }
}