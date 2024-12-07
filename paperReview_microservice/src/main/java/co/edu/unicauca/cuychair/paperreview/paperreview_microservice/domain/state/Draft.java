package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;

public class Draft implements PaperReviewState{
    @Override
    public Result toModeration() {
        return new Result(true,"Articulo enviado a moderacion");
    }

    @Override
    public Result toDraft() {
        return new Result(false,"El articulo ya esta en borrador");
    }

    @Override
    public Result toPublished() {
        return new Result(false,"Para publicar un articulo primero tiene que ser revisado");
    }

    @Override
    public Result toRejected() {
        return new Result(false,"Para rechazar un articulo primero tiene que ser revisado");
    }
}
