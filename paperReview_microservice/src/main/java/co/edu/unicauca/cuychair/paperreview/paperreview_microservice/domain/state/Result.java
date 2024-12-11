package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;
import lombok.Getter;

@Getter
public class Result {
    boolean isChangeValid;
    String comment;
    //String newState;
    public Result(boolean isChangeValid, String comment){
        this.isChangeValid=isChangeValid;
        this.comment=comment;
    }
    
}
