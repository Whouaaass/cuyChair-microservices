package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Paper;

public interface ServicesPaperPort {
    Paper addPaper(Paper paper);
    Paper removePaper(Paper paper);
    Paper updatePaper(Paper paper);
    Paper findById(int id);
}
