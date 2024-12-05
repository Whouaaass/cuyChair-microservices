package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.repositoris;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entitis.UserEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.User;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.UserRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private List<UserEntity> users;

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User removeUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
