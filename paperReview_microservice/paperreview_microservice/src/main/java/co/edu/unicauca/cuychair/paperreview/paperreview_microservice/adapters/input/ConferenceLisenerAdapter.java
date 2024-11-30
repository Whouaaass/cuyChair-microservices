package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input.ServiceConferencePort;

public class ConferenceLisenerAdapter {

    private final ServiceConferencePort services;

    public ConferenceLisenerAdapter(ServiceConferencePort services) {
        this.services = services;
    }
}
