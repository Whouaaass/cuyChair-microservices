package co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI;

import co.edu.unicauca.cuychair.gui.domain.Paper;
import co.edu.unicauca.cuychair.gui.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaperReviewDTO {
    private int idPaperReview;
    private Paper paper;
    private User evaluator;
    private boolean reviewed;
    private String comment;
    //private PaperReviewState state;
}
