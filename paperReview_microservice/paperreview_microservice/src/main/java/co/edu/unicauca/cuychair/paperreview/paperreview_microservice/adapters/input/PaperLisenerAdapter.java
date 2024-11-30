package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input.ServicesPaperPort;

public class PaperLisenerAdapter {

    private final ServicesPaperPort services;

    public PaperLisenerAdapter(ServicesPaperPort services) {
        this.services = services;
    }
}
