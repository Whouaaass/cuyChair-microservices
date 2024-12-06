package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.mapper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.PaperEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Paper;

public class PaperRepositoryMaper {

    public Paper toPaper(PaperEntity paperEntity) {
        return new Paper(paperEntity.getId(), paperEntity.getTitle(), paperEntity.getAbstract(), paperEntity.getSubtitle(), paperEntity.getAuthor(), paperEntity.getConference());
    }

    public PaperEntity toPaperEntity(Paper paper) {
        return new PaperEntity(paper.getId(), paper.getTitle(), paper.getAbstract(), paper.getSubtitle(), paper.getAuthor(), paper.getConference());
    }

}
