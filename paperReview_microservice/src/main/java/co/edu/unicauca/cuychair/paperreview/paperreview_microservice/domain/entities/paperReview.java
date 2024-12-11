package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Moderation;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.PaperReviewState;
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

    public paperReview(int idPaperReview, Paper paper, User evaluator, boolean reviewed, String comment, String currentState){
        this.idPaperReview = idPaperReview;
        this.paper = paper;
        this.evaluator = evaluator;
        this.reviewed = false;
        this.comment = comment;
        this.currentState = "MODERATION";
    }

    public Result toModeration() {
        return state.toModeration();
    }

    public Result toDraft() {
        return state.toDraft();
    }

    public Result toPublished() {
        return state.toPublished();
    }

    public Result toRejected() {
        return state.toRejected();
    }

    public Result changeState(String newState){
        String upperNewState = newState.toUpperCase();
        Result r;
        switch(upperNewState){
            case "DRAFT":
                r = toDraft();
                System.out.println("\nRetornando");
                return r;//Si lo mandan a draft aún no cuenta como revisado
            case "MODERATION":
                r = toModeration();
                return r;//En moderación aún no es revisado
            case "PUBLISHED":
                r = toPublished();
                break;
            case "REJECTED":
                r = toRejected();
                break;
            default:
                System.out.println("\nEstado invalido para change state");
                return new Result(false,"Estado invalido");
        }
        System.out.println("\nVerificando si el cambio es valido");
        if(r.isChangeValid()){
            System.out.println("Entro al if");
            this.reviewed=true;
            this.currentState=r.getNewState();
        }
        System.out.println("Retornando");
        return r;//Si el estado del artículo cambia a rechazado o publicado significa que ya ha sido revisado
    }

}
