package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.repositories;

<<<<<<< HEAD:paperReview_microservice/src/main/java/co/edu/unicauca/cuychair/paperreview/paperreview_microservice/adapters/output/repositories/UserRepositoryAdapter.java
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.UserEntity;
=======
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entitis.UserEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.mapper.UserRepositoryMaper;
>>>>>>> ec9fe43d46420ac8ba920c26f3e74b6feda685c6:paperReview_microservice/src/main/java/co/edu/unicauca/cuychair/paperreview/paperreview_microservice/adapters/output/repositoris/UserRepositoryAdapter.java
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.User;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.UserRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private List<UserEntity> users;
    private UserRepositoryMaper maper;

    @Override
    public User addUser(User user) {
        if(users == null){
            this.users = new ArrayList<>();
            this.maper = new UserRepositoryMaper();
        }
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
        if(index == -1){
            return null;
        }
        users.set(index, maper.toUserEntity(user));
        return user;
    }

    @Override
    public User findById(int id) {
        for(UserEntity user : users){
            if(user.getId() == id){
                return maper.toUser(user);
            }
        }
        return null;
    }

    @Override
    public User findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
