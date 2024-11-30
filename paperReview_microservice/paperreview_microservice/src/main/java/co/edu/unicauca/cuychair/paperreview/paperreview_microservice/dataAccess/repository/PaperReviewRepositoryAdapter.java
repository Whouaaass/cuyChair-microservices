package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.dataAccess.repository;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.dataAccess.repository.entitis.PaperReviewEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.paperReview;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.PaperReviewRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaperReviewRepositoryAdapter implements PaperReviewRepositoryPort {
    private List<PaperReviewEntity> paperReviews;

    @Override
    public paperReview addpaperReview(paperReview paperReview) {
        return null;
    }
}