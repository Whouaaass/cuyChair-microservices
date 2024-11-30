package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.User;

public interface UserRepositoryPort {
    User addUser(User user);
    User removeUser(User user);
    User updateUser(User user);
}
