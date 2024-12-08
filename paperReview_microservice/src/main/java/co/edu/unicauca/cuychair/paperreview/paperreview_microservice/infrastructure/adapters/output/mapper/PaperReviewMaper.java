package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.PaperReviewEntity;

public class PaperReviewMaper {

    public paperReview topaperReview(PaperReviewEntity paperReviewEntity) {
        return new paperReview(paperReviewEntity.getIdPaperReview(),paperReviewEntity.getPaper(),paperReviewEntity.getEvaluator(),paperReviewEntity.isReviewed(),paperReviewEntity.getComment(),paperReviewEntity.getState());
    }

    public PaperReviewEntity toPaperReviewEntity(paperReview paperReview) {
        return new PaperReviewEntity(paperReview.getIdPaperReview(),paperReview.getPaper(),paperReview.getEvaluator(),paperReview.isReviewed(),paperReview.getComment(),paperReview.getState());
    }
}
