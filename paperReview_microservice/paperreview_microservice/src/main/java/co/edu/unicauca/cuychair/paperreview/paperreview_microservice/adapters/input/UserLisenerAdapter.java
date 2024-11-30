package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.input;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input.ServiceUserPort;

public class UserLisenerAdapter {

    private final ServiceUserPort services;
    public UserLisenerAdapter(ServiceUserPort services) {
        this.services = services;
    }
}
