package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input.ServicePaperReviewPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paperReview")
public class PaperReviewRestAdaper {
    private final ServicePaperReviewPort service;

    public PaperReviewRestAdaper(ServicePaperReviewPort service) {
        this.service = service;
    }


}
