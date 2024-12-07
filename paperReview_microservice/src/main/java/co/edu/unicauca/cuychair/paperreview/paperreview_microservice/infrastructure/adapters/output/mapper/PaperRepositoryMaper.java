package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Paper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.PaperEntity;

public class PaperRepositoryMaper {

    public Paper toPaper(PaperEntity paperEntity) {
        return new Paper(paperEntity.getId(), paperEntity.getTitle(), paperEntity.getAbstract(), paperEntity.getSubtitle(), paperEntity.getAuthor(), paperEntity.getConference());
    }

    public PaperEntity toPaperEntity(Paper paper) {
        return new PaperEntity(paper.getId(), paper.getTitle(), paper.getAbstract(), paper.getSubtitle(), paper.getAuthor(), paper.getConference());
    }

}
