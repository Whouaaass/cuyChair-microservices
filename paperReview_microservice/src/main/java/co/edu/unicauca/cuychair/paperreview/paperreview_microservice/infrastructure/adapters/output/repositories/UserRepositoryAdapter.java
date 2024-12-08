package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.repositories;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.UserEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper.UserRepositoryMaper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.application.ports.output.UserRepositoryPort;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.User;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private List<UserEntity> users = new ArrayList<>();;
    private UserRepositoryMaper maper = new UserRepositoryMaper();;

    @Override
    public User addUser(User user) {        
        users.add(maper.toUserEntity(user));
        return user;
    }

    @Override
    public User removeUser(User user) {
        users.remove(maper.toUserEntity(user));
        return user;
    }

    @Override
    public User updateUser(User user) {
        int index = users.indexOf(maper.toUserEntity(user));
        if (index == -1) {
            return null;
        }
        users.set(index, maper.toUserEntity(user));
        return user;
    }

    @Override
    public User findById(int id) {
        for (UserEntity user : users) {
            if (user.getId() == id) {
                return maper.toUser(user);
            }
        }
        return null;
    }

}
