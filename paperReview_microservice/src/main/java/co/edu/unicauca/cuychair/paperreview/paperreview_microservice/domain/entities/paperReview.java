package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Draft;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Moderation;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.PaperReviewState;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Published;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Rejected;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Result;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class paperReview {
    private int idPaperReview;
    private Paper paper;
    private User evaluator;
    private boolean reviewed;
    private String comment;
    private String currentState;
    private PaperReviewState state;//TODO

    public paperReview(int idPaperReview, Paper paper, User evaluator, boolean reviewed, String comment, String currentState, PaperReviewState state){
        this.idPaperReview = idPaperReview;
        this.paper = paper;
        this.evaluator = evaluator;
        this.reviewed = reviewed;
        this.comment = comment;
        if(currentState==null){
            System.out.println("Inicializando currentState en moderation");
            this.currentState = "MODERATION";
        }else{
            this.currentState = currentState;
        }  
        if(this.state==null&&state==null){
            System.out.println("Inicializando State interfaz en moderation desde paperReview");
            this.state = new Moderation();
        }else{
            this.state = state;
        }
    }

    public Result toModeration() {
        Result r = state.toModeration();
        System.out.println("TOMODERATION RESULT:"+r.getComment());
        if(r.isChangeValid()){
            state = new Moderation();
        }
        return r;
    }

    public Result toDraft() {
        System.out.println("Estado entrante:"+state.getClass());
        Result r = state.toDraft();
        System.out.println("TODRAFT RESULT:"+r.getComment());
        System.out.println("Draft antes del if");
        if(r.isChangeValid()){
            state = new Draft();
            System.out.println("Entro y sobrevivio a la asignacion");
        }
        System.out.println("Estado final"+state.getClass());
        return r;
    }

    public Result toPublished() {
        Result r = state.toPublished();
        System.out.println("TOPUBLISHED RESULT:"+r.getComment());
        if(r.isChangeValid()){
            state = new Published();
        }
        return r;
    }

    public Result toRejected() {
        Result r = state.toRejected();
        if(r.isChangeValid()){
            state = new Rejected();
        }
        return r;
    }

    public Result changeState(String newState){
        String upperNewState = newState.toUpperCase();
        Result r;
        switch(upperNewState){
            case "DRAFT":
                r = toDraft();
                if(r.isChangeValid()){
                    this.currentState="DRAFT";
                }
                return r;//Si lo mandan a draft aún no cuenta como revisado
            case "MODERATION":
                r = toModeration();
                if(r.isChangeValid()){
                    this.currentState="MODERATION";
                }
                return r;//En moderación aún no es revisado
            case "PUBLISHED":
                r = toPublished();
                if(r.isChangeValid()){
                    this.currentState="PUBLISHED";
                }
                this.reviewed=true;
                return r;
            case "REJECTED":
                r = toRejected();
                if(r.isChangeValid()){
                    this.currentState="REJECTED";
                }
                this.reviewed=true;
                return r;
            default:
                System.out.println("\nEstado invalido para change state");
                return new Result(false,"Estado invalido");
        }
    }

}
