package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.services;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServicesPaperPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.PaperRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Paper;

import org.springframework.stereotype.Service;

@Service
public class PaperServices implements ServicesPaperPort {

    private PaperRepositoryPort repository;

    @Override
    public Paper addPaper(Paper paper) {
        return repository.addPaper(paper);
    }

    @Override
    public Paper removePaper(Paper paper) {
        return repository.removePaper(paper);
    }

    @Override
    public Paper updatePaper(Paper paper) {
        return repository.updatePaper(paper);
    }

    @Override
    public Paper findById(int id) {
        return repository.findById(id);
    }
}
