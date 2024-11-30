package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.paperReview;

public interface PaperReviewRepositoryPort {
    paperReview addpaperReview(paperReview paperReview);
}
