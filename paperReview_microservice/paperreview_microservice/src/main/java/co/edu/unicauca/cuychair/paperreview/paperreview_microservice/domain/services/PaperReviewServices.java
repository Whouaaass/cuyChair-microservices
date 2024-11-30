package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.services;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.paperReview;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input.ServicePaperReviewPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.PaperReviewRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class PaperReviewServices implements ServicePaperReviewPort {

    private PaperReviewRepositoryPort repository;

    @Override
    public paperReview addpaperReview(paperReview paperReview) {
        return repository.addpaperReview(paperReview);
    }
}
