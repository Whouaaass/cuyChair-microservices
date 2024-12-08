package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Paper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.PaperEntity;

public class PaperRepositoryMaper {

    public Paper toPaper(PaperEntity paperEntity) {
        return new Paper(paperEntity.getId(), paperEntity.getTitle(), paperEntity.getAbstract(), paperEntity.getSubtitle(), paperEntity.getAuthor(), paperEntity.getConference());
    }

    public PaperEntity toPaperEntity(Paper paper) {
        return new PaperEntity(paper.getId(), paper.getTitle(), paper.getAbstract(), paper.getSubtitle(), paper.getAuthor(), paper.getConference());
    }

    // Convierte una lista de PaperEntity a una lista de Paper
    public List<Paper> toPaperList(List<PaperEntity> paperEntities) {
        return paperEntities.stream()
                .map(this::toPaper) // Usa el método toPaper para mapear cada elemento
                .collect(Collectors.toList());
    }

    // Convierte una lista de Paper a una lista de PaperEntity
    public List<PaperEntity> toPaperEntityList(List<Paper> papers) {
        return papers.stream()
                .map(this::toPaperEntity) // Usa el método toPaperEntity para mapear cada elemento
                .collect(Collectors.toList());
    }

}
