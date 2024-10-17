package co.edu.unicauca.cuychair.conference_microservice.data_access;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {
    private final List<User> userList;
    private final AtomicInteger idCounter;

    public UserRepository() {
        this.userList = new ArrayList<User>();
        this.idCounter = new AtomicInteger(1);
        addTestRegisters();
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
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
            if (u.getId() == userId) {
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
            if (u.getId() == userId) {
                userList.remove(u);
                return u;
            }
        }
        return null;
    }

    public void addTestRegisters() {
        addUser( new User(null, "Juan", "juandev@gmail.com", "12345234", "El amante del luna"));
        addUser( new User(null, "Pedro", "pdto@dev.com", "13333334", "Piedra que te doy"));
        addUser( new User(null, "Maria", "carmen.mario@gmail.com", "12345234", "La que se fue"));        
    }
}
