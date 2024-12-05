package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.repositoris;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entitis.PaperReviewEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.paperReview;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.PaperReviewRepositoryPort;
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