package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.repositories;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.PaperReviewEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.PaperReviewRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaperReviewRepoAdapter implements PaperReviewRepositoryPort {
    private List<PaperReviewEntity> paperReviews;

    @Override
    public paperReview addpaperReview(paperReview paperReview) {
        return null;
    }
}