package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.input;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.User;

public interface ServiceUserPort {
    User addUser(User user);
    User removeUser(User user);
    User updateUser(User user);
}
