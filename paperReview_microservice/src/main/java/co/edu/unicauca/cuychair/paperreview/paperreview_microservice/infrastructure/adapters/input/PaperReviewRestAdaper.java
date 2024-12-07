package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.input;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServicePaperReviewPort;

@RestController
@RequestMapping("/paperReview")
public class PaperReviewRestAdaper {
    private final ServicePaperReviewPort service;

    public PaperReviewRestAdaper(ServicePaperReviewPort service) {
        this.service = service;
    }


}
