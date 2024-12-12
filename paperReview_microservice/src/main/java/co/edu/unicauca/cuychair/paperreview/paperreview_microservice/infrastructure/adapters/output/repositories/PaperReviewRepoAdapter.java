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
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PaperReviewRepoAdapter implements PaperReviewRepositoryPort {
    private List<PaperReviewEntity> paperReviews;
    
    private  PaperReviewMaper maper = new PaperReviewMaper();
    private AtomicInteger indexCounter;

    public PaperReviewRepoAdapter(){
        this.paperReviews = new ArrayList<PaperReviewEntity>();
        this.indexCounter = new AtomicInteger(1);
    }

    @Override
    public paperReview addpaperReview(paperReview paperReview) {
        if(paperReviews==null){
            this.paperReviews = new ArrayList<PaperReviewEntity>();
            maper = new PaperReviewMaper();
        }
        paperReview.setIdPaperReview(this.indexCounter.getAndIncrement());
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
    public Result changeState(int paperReviewId, int reviewerId, String newState){
        Result result = null;
        if(paperReviews.size()==0){
            return new Result(false, "No hay revisiones en el repositorio");
        }
        for(int i=0;i<paperReviews.size();i++){
            if(paperReviews.get(i).getIdPaperReview()==paperReviewId){
                if(paperReviews.get(i).getEvaluator().getId()!=reviewerId){//Evalua si corresponde el evaluador con el solicitante
                    return new Result(false,"Evaluador no autorizado");
                }
                paperReview paperReview = maper.topaperReview(paperReviews.get(i));
                result = paperReview.changeState(newState);
                paperReviews.set(i, maper.toPaperReviewEntity(paperReview));
                break;
            }
        }
        return result;
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

    @Override
    public paperReview getPaperReviewByPaper(int paperId) {
        for(int i = 0;i < paperReviews.size();i++){
            if(paperReviews.get(i).getPaper().getId()==paperId){
                return maper.topaperReview(paperReviews.get(i));
            }
        }
        return null;
    }

    @Override
    public List<paperReview> listPaperReviewsByConference(int conferenceId) {
        List<paperReview> conferencePaperReviewList = new ArrayList<paperReview>();
        for(int i = 0;i < paperReviews.size();i++){
            if(paperReviews.get(i).getPaper().getConference()==conferenceId){
                conferencePaperReviewList.add(maper.topaperReview(paperReviews.get(i)));
            }
        }
        return conferencePaperReviewList;
    }


}