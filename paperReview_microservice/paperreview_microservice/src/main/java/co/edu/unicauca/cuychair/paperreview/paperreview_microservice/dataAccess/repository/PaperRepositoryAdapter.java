package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.dataAccess.repository;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.dataAccess.repository.entitis.PaperEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.PaperRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaperRepositoryAdapter implements PaperRepositoryPort {
    private List<PaperEntity> papers;

    @Override
    public Paper addPaper(Paper paper) {
        return paper;
    }

    @Override
    public Paper updatePaper(Paper paper) {
        return null;
    }

    @Override
    public Paper removePaper(Paper paper) {
        return null;
    }

}