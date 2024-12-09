package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServicePaperReviewPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;


@RestController
@RequestMapping("/paperReview")
public class PaperReviewRestAdaper {


    private final ServicePaperReviewPort service;
    
    public PaperReviewRestAdaper(ServicePaperReviewPort service) {
        this.service = service;
    }
    
    @PatchMapping("/changeState/{paperReviewId}/{newState}") // Ruta completa: /paperReview/changeState/{paperReviewId}/{newState}
    public boolean changeState(@PathVariable int paperReviewId, @PathVariable String newState, @RequestBody String comment) {

        return service.changeState(paperReviewId, newState);
    }

    @PostMapping("/add") // Ruta completa: /paperReview/add
    public paperReview addPaperReview(@RequestBody paperReview paperReview) {
        return service.addpaperReview(paperReview);
    }

    @GetMapping("/get/{paperReviewId}") // Ruta completa: /paperReview/get/{paperReviewId}
    public paperReview getPaperReview(@PathVariable int paperReviewId) {
        return service.getPaperReview(paperReviewId);
    }

    @GetMapping("/getByPaper/{paperId}") // Ruta completa: /paperReview/getByPaper/{paperId}
    public paperReview getPaperReviewByPaper(@PathVariable int paperId) {
        return null; //service.getPaperReviewByPaper(paperId);
    }

    @DeleteMapping("/delete/{paperReviewId}") // Ruta completa: /paperReview/delete/{paperReviewId}
    public paperReview deletePaperReview(@PathVariable int paperReviewId) {
        return service.deletePaperReview(paperReviewId);
    }

    @GetMapping("/list") // Ruta completa: /paperReview/list
    public List<paperReview> listPaperReviews() {
        return service.listPaperReview();
    }

    @GetMapping("/listByConference/{conferenceId}") // Ruta completa: /paperReview/listByReviewer/{reviewerId}
    public List<paperReview> listPaperReviewsByReviewer(@PathVariable int conferenceId) {
        return null; // service.listPaperReviewByConference(conferenceId);
    }    
}
