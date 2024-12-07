package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.services;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.input.ServiceUserPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.UserRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.User;

import org.springframework.stereotype.Service;

@Service
public class UserServices implements ServiceUserPort {

    private UserRepositoryPort repository;

    @Override
    public User addUser(User user) {
        return repository.addUser(user);
    }

    @Override
    public User removeUser(User user) {
        return repository.removeUser(user);
    }

    @Override
    public User updateUser(User user) {
        return repository.updateUser(user);
    }

    @Override
    public User findById(int id) {
        return repository.findById(id);
    }

}
