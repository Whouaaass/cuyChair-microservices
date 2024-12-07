package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities;

import java.util.List;

public class PaperReviewEntity {
    int idPaperReview;
    int idConference;
    int idPaper;
    List<UserEntity> reviewerList;
    //PaperReviewState state;
    String comment;

}
