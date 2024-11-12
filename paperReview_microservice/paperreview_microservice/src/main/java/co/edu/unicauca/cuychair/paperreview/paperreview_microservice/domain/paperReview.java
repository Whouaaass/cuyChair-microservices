package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain;

import java.util.List;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.PaperReviewState;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class paperReview {
    int idPaperReview;
    int idConference;
    int idPaper;

    List<User> reviewerList;
    PaperReviewState state;

    boolean changeState(PaperReviewState prmState){
        return true;//TODOO
    }

    User addReviewer(User prmUser){
        return prmUser;
    }
}
