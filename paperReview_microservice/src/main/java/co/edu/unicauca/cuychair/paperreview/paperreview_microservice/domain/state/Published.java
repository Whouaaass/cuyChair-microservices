package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;

public class Published implements PaperReviewState{

    @Override
    public Result toModeration() {
        return new Result(false,"No puedes cambiar un articulo publicado");
    }

    @Override
    public Result toDraft() {
        return new Result(false,"No puedes cambiar un articulo publicado");
    }

    @Override
    public Result toPublished() {
        return new Result(false, "El articulo ya esta publicado");
    }

    @Override
    public Result toRejected() {
        return new Result(false,"No puedes rechazar un articulo publicado");
    }

}
