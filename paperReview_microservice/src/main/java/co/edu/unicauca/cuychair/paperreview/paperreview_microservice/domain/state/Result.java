package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Result {
    boolean isChangeValid;
    String comment;
}
