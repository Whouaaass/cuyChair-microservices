package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;

public interface ServicePaperReviewPort {
    paperReview addpaperReview(paperReview paperReview);
}
