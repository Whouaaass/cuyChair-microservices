package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.paperReview;

public interface ServicePaperReviewPort {
    paperReview addpaperReview(paperReview paperReview);
}
