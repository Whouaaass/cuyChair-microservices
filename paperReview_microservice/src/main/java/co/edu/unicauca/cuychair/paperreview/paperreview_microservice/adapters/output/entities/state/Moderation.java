package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state;

public class Moderation implements PaperReviewState{
    String state = "MODERATION";
    @Override
    public void review() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getState'");
    }

    @Override
    public String getState() {
        return state;
    }
}
