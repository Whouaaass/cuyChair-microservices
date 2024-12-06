package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.state;

public class Draft implements PaperReviewState{
    String state = "DRAFT";
    @Override
    public void review() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'review'");
    }
    @Override
    public String getState() {
        return state;
    }
}
