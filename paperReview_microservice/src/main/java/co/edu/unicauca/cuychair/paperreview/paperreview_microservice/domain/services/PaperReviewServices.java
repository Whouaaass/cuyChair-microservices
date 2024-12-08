package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.services;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServicePaperReviewPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.PaperReviewRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;

import org.springframework.stereotype.Service;

@Service
public class PaperReviewServices implements ServicePaperReviewPort {

    private PaperReviewRepositoryPort repository;

    @Override
    public paperReview addpaperReview(paperReview paperReview) {
        return repository.addpaperReview(paperReview);
    }

    @Override
    public paperReview getPaperReview(int paperId) {
        return repository.getPaperReview(paperId);
    }

    @Override
    public boolean changeState(int paperReviewId, String newState) {
        return repository.changeState(paperReviewId, newState);
    }

    

}
