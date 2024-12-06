package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.mapper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.UserEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.User;

public class UserRepositoryMaper {

    public User toUser(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getDescription(), userEntity.getPhone());
    }

    public UserEntity toUserEntity(User user) {
        return new UserEntity(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getDescription(), user.getPhone());
    }
}
