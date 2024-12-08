package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.User;

public interface UserRepositoryPort{
    User addUser(User user);
    User removeUser(User user);
    User updateUser(User user);
    User findById(int id);
}
