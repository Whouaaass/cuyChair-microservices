package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Rejected")
public class Rejected implements PaperReviewState{

    @Override
    public Result toModeration() {
        return new Result(false,"No puedes cambiar un articulo rechazado");
    }

    @Override
    public Result toDraft() {
        return new Result(false,"No puedes cambiar un articulo rechazado");
    }

    @Override
    public Result toPublished() {
        return new Result(false, "No puedes publicar un articulo rechazado");
    }

    @Override
    public Result toRejected() {
        return new Result(false,"El articulo ya esta rechazado");
    }

    
}
