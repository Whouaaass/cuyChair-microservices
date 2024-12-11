package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state;

public class Moderation implements PaperReviewState{
    @Override
    public Result toModeration() {
        return new Result(false,"El articulo ya esta en moderación");
    }

    @Override
    public Result toDraft() {
        return new Result(true,"Articulo enviado a borrador","DRAFT");
    }

    @Override
    public Result toPublished() {
        return new Result(true,"Articulo publicado","PUBLISHED");
    }

    @Override
    public Result toRejected() {
        return new Result(true,"Articulo rechazado","REJECTED");
    }
}
