package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities;


import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.PaperReviewState;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class paperReview {
    private int idPaperReview;
    private Paper paper;
    private User evaluator;
    private boolean reviewed;
    private String comment;
    private PaperReviewState state;

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

    public Result changeState(String newState) {
        String upperNewState = newState.toUpperCase();
        switch(upperNewState){
            case "DRAFT":
            return toDraft();
            case "MODERATION":
                return toModeration();
            case "PUBLISHED":
                return toPublished();
            case "REJECTED":
                return toRejected();
            default:
                return new Result(false,"Estado invalido");
        }
    }
}
