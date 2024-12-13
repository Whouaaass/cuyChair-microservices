package co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaperReviewItemDTO {
    private Integer idPaperReview;
    private PaperDTO paper;
    private Object evaluator;
    private boolean reviewed;
    private String comment;
    private String currentState;
    private StateDTO state;

    @Data
    public static class PaperDTO {
        private Integer id;
        private String title;
        private String subtitle;
        private Integer author;
        private Integer conference;
        @JsonProperty("abstract")
        private String abstract_;
    }

    @Data
    public static class StateDTO {
        private String type;
    }

    @Override
    public String toString() {
        return paper.getTitle();
    }
}
