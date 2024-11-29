package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain;

import java.util.List;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.PaperReviewState;
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

    boolean changeState(PaperReviewState prmState){
        return true;//TODOO
    }

    User addReviewer(User prmUser){return prmUser;}
}
