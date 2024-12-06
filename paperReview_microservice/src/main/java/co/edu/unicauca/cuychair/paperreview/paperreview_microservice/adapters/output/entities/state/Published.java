package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state;

public class Published implements PaperReviewState{
    String state = "PUBLISHED";

    public String getState(){
        return state;
    }

    @Override
    public void review() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'review'");
    }
}
