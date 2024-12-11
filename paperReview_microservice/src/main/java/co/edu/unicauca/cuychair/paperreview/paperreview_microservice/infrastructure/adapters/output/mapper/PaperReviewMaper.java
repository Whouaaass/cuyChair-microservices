package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.PaperReviewEntity;

public class PaperReviewMaper {
    public paperReview topaperReview(PaperReviewEntity paperReviewEntity) {
        return new paperReview(paperReviewEntity.getIdPaperReview(),
        paperReviewEntity.getPaper(),
        paperReviewEntity.getEvaluator(),
        paperReviewEntity.isReviewed(),
        paperReviewEntity.getComment(),
        paperReviewEntity.getCurrentState(),
        paperReviewEntity.getState());
    }

    public PaperReviewEntity toPaperReviewEntity(paperReview paperReview) {
        return new PaperReviewEntity(paperReview.getIdPaperReview(),
        paperReview.getPaper(),
        paperReview.getEvaluator(),
        paperReview.isReviewed(),
        paperReview.getComment(),
        paperReview.getCurrentState(),
        paperReview.getState());
    }
    // Convierte una lista de PaperReviewEntity a una lista de PaperReview
    public List<paperReview> toPaperReviewList(List<PaperReviewEntity> paperReviewEntities) {
        return paperReviewEntities.stream()
                .map(this::topaperReview) // Usa el método toPaperReview para mapear cada elemento
                .collect(Collectors.toList());
    }

    // Convierte una lista de PaperReview a una lista de PaperReviewEntity
    public List<PaperReviewEntity> toPaperReviewEntityList(List<paperReview> paperReviews) {
        return paperReviews.stream()
                .map(this::toPaperReviewEntity) // Usa el método toPaperReviewEntity para mapear cada elemento
                .collect(Collectors.toList());
    }
}
