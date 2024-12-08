package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.repositories;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.PaperReviewEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.PaperReviewRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper.PaperReviewMaper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaperReviewRepoAdapter implements PaperReviewRepositoryPort {
    private List<PaperReviewEntity> paperReviews;
    private  PaperReviewMaper maper;

    @Override
    public paperReview addpaperReview(paperReview paperReview) {
        if(paperReviews==null){
            this.paperReviews = new ArrayList<PaperReviewEntity>();
            maper = new PaperReviewMaper();
        }
        if(paperReviews.add(maper.toPaperReviewEntity(paperReview))){
            return paperReview;
        }
        return null;
    }
}