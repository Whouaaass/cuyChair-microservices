package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.Paper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.User;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.PaperReviewState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PaperReviewEntity {
    private int idPaperReview;
    private Paper paper;
    private User evaluator;
    private boolean reviewed;
    private String comment;
    private PaperReviewState state;

}
