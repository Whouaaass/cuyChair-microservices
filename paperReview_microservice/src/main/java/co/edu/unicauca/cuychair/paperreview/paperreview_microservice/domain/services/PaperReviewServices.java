package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.services;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServicePaperReviewPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.PaperReviewRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.state.Result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperReviewServices implements ServicePaperReviewPort {
    @Autowired
    private PaperReviewRepositoryPort repository;

    @Override
    public paperReview addpaperReview(paperReview paperReview) {
        return repository.addpaperReview(paperReview);
    }

    @Override
    public paperReview getPaperReview(int paperId) {
        return repository.getPaperReview(paperId);
    }

    @Override
    public Result changeState(int paperReviewId, int reviewerId, String newState) {
        return repository.changeState(paperReviewId, reviewerId, newState);
    }

    @Override
    public paperReview deletePaperReview(int paperReviewId) {
        return repository.deletePaperReview(paperReviewId);
    }

    @Override
    public List<paperReview> listPaperReview() {
        return repository.listPaperReview();
    }

    @Override
    public paperReview getPaperReviewByPaper(int paperId) {
        return repository.getPaperReviewByPaper(paperId);
    }

    @Override
    public List<paperReview> listPaperReviewsByConference(int conferenceId) {
        return repository.listPaperReviewsByConference(conferenceId);
    }

}
