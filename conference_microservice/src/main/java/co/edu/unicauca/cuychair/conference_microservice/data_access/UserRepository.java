package co.edu.unicauca.cuychair.conference_microservice.data_access;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.User;

@Repository
public class UserRepository {
    private final List<User> userList;
    private final AtomicInteger idCounter;

    public UserRepository() {
        this.userList = new ArrayList<>();
        this.idCounter = new AtomicInteger(1);
        addTestRegisters();
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(Integer id) {        
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public User addUser(User user) {
        user.setId(idCounter.getAndIncrement());
        userList.add(user);
        return user;
    }

    public User updateUser(Integer userId, User user) {
        for (User u : userList) {
            if (u.getId().equals(userId)) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                u.setPhone(user.getPhone());
                return u;
            }
        }
        return null;
    }

    public User deleteUser(Integer userId) {
        for (User u : userList) {
            if (u.getId().equals(userId)) {
                userList.remove(u);
                return u;
            }
        }
        return null;
    }

    final public void addTestRegisters() {
        addUser( new User(1, "Juan", "juandev@gmail.com", "12345234", "El amante del luna"));
        addUser( new User(1, "Pedro", "pdto@dev.com", "13333334", "Piedra que te doy"));
        addUser( new User(1, "Maria", "carmen.mario@gmail.com", "12345234", "La que se fue"));        
    }
}
