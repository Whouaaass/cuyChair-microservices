package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Paper;

public interface PaperRepositoryPort {
    Paper addPaper(Paper paper);
    Paper updatePaper(Paper paper);
    Paper removePaper(Paper paper);
    Paper findById(int id);
}
