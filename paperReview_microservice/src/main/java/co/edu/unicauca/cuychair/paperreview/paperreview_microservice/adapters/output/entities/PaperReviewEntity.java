package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities;

import java.util.List;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state.Moderation;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state.PaperReviewState;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state.Published;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state.Rejected;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state.Draft;

public class PaperReviewEntity {
    int idPaperReview;
    int idConference;
    int idPaper;
    List<UserEntity> reviewerList;
    PaperReviewState state;
    String comment;

    boolean changeState(String newState){
        String varState = newState.toUpperCase();
        switch(varState){
            case "PUBLISHED":
                Published publishedState = new Published();
                state = publishedState;
                //Validar
                return true;
            case "MODERATION":
                Moderation moderationState = new Moderation();
                state = moderationState;
                return true;
            case "DRAFT":
                Draft draftState = new Draft();
                state = draftState;
                return true;
            case "REJECTED":
                Rejected rejectedState = new Rejected();
                state = rejectedState;
                return true;
            default:
                return false;
        }
    }

    UserEntity addReviewer(UserEntity user){
        reviewerList.add(user);
        return reviewerList.getLast();
    }
}
