package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities;

import java.util.List;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state.Moderation;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state.PaperReviewState;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state.Result;

public class PaperReviewEntity {
    int idPaperReview;
    int idConference;
    int idPaper;
    List<UserEntity> reviewerList;
    PaperReviewState state;
    String comment;

    public PaperReviewEntity(){
        Moderation moderationState = new Moderation();
        state = moderationState;
    }

    UserEntity addReviewer(UserEntity user){
        reviewerList.add(user);
        return reviewerList.getLast();
    }
    
    public Result toModeration() {
        return this.state.toModeration();
    }

    public Result toDraft() {
        return this.state.toDraft();
    }

    public Result toPublished() {
        return this.state.toPublished();
    }

    public Result toRejected() {
        return this.state.toRejected();
    }

}
