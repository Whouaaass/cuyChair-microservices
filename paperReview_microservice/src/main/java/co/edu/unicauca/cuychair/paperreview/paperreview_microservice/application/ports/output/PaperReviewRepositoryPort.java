package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;

public interface PaperReviewRepositoryPort {
    paperReview addpaperReview(paperReview paperReview);
}
