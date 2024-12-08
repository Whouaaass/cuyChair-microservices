package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.repositories;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.PaperReviewEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.PaperReviewRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Result;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper.PaperReviewMaper;
import io.micrometer.observation.annotation.Observed;

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

    @Override
    public paperReview getPaperReview(int paperReviewId) {
        for(int i=0; i < paperReviews.size();i++){
            if(paperReviews.get(i).getIdPaperReview()==paperReviewId){
                return maper.topaperReview(paperReviews.get(i));
            }
        }
        return null;
    }

    @Override
    public boolean changeState(int paperReviewId, String newState){
        int idx = getPaperReview(paperReviewId).getPaper().getId();
        Result result= maper.topaperReview(paperReviews.get(idx)).changeState(newState);
        return result.isChangeValid();
    }

    @Override
    public paperReview deletePaperReview(int paperReviewId) {
        for(int i=0; i < paperReviews.size();i++){
            if(paperReviews.get(i).getIdPaperReview()==paperReviewId){
                paperReview paperReview = maper.topaperReview(paperReviews.get(i));
                paperReviews.remove(i);
                return paperReview;
            }
        }
        return null;
    }

    @Override
    public List<paperReview> listPaperReview() {
        return maper.toPaperReviewList(paperReviews);
    }


}