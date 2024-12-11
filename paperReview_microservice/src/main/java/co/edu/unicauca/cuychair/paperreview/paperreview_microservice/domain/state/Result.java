package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;
import lombok.Getter;

@Getter
public class Result {
    boolean isChangeValid;
    String comment;
    String newState;
    //Constructor caso no exitoso
    public Result(boolean isChangeValid, String comment){
        this.isChangeValid=isChangeValid;
        this.comment=comment;
    }
    //Constructor caso exitoso
    public Result(boolean isChangeValid, String comment, String newState){
        this.isChangeValid=isChangeValid;
        this.comment=comment;
        this.newState=newState;
    }
    public void setNewState(String newState){
        this.newState=newState;
    }
}
