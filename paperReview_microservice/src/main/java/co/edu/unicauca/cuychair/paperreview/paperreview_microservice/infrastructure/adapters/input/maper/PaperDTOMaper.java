package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.maper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input.dto.PaperDTO;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Paper;

public class PaperDTOMaper {

    public Paper toPaper(PaperDTO paperDTO) {
        return new Paper(paperDTO.getId(), paperDTO.getTitle(), paperDTO.getAbstract(), paperDTO.getSubTitle(), paperDTO.getIdAuthor(), paperDTO.getIdConference());
    }

    public PaperDTO toPaperDTO(Paper paper) {
        return new PaperDTO(paper.getId(), paper.getTitle(), paper.getAbstract(), paper.getSubtitle(), paper.getAuthor(), paper.getConference());
    }
}
