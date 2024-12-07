package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.mapper;

import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.entities.User;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.infrastructure.adapters.output.entities.UserEntity;

public class UserRepositoryMaper {

    public User toUser(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getDescription(), userEntity.getPhone());
    }

    public UserEntity toUserEntity(User user) {
        return new UserEntity(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getDescription(), user.getPhone());
    }
}
