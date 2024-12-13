package co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaperReviewResDTO {
    private Long idPaperReview;
    private Paper paper;
    private Evaluator evaluator;
    private boolean reviewed;
    private String comment;
    private String currentState;
    private State state;

    @Data
    public static class Paper {
        private Long id;
        private String title;
        private String subtitle;
        private Long author;
        private Integer conference;
        @JsonProperty("abstract")
        private String abstract_;
    }

    @Data
    public static class Evaluator {
        private Long id;
        private String name;
        private String lastName;
        private String email;
        private String password;
        private String description;
        private Integer phone;
    }

    @Data
    public static class State {
        private String type;
    }
}
