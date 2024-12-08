package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServicePaperReviewPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.paperReview;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/paperReview")
public class PaperReviewRestAdaper {
    private final ServicePaperReviewPort service;
    
    public PaperReviewRestAdaper(ServicePaperReviewPort service) {
        this.service = service;
    }
    @GetMapping("/changeState/{paperReviewId}/{newState}") // Ruta completa: /paperReview/changeState/{paperReviewId}/{newState}
    public boolean changeState(@PathVariable int paperReviewId, @PathVariable String newState) {
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

    @DeleteMapping("/delete/{paperReviewId}") // Ruta completa: /paperReview/delete/{paperReviewId}
    public paperReview deletePaperReview(@PathVariable int paperReviewId) {
        return service.deletePaperReview(paperReviewId);
    }

    @GetMapping("/list") // Ruta completa: /paperReview/list
    public List<paperReview> listPaperReviews() {
        return service.listPaperReview();
    }
    
}
