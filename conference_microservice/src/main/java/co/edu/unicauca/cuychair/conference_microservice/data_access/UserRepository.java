package co.edu.unicauca.cuychair.conference_microservice.data_access;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.User;

@Repository
public class UserRepository {
    private final Map<Integer, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
        addTestRegisters();
    }

    public List<User> getAllUsers() {
        return List.copyOf(users.values());
    }

    public User getUserById(Integer id) {
        return users.get(id);
    }

    public User addUser(User user) {
        if (user == null)
            return user;
        users.put(user.getId(), user);
        return user;
    }

    public User updateUser(Integer userId, User user) {
        User u = users.get(userId);
        if (u == null)
            return null;

        u.setName(u.getName());
        u.setEmail(u.getEmail());
        u.setPhone(u.getPhone());
        return u;
    }

    public User deleteUser(Integer userId) {        
        return users.remove(userId);
    }

    final public void addTestRegisters() {
        addUser(new User(1, "Juan", "juandev@gmail.com", "12345234", "El amante del luna"));
        addUser(new User(1, "Pedro", "pdto@dev.com", "13333334", "Piedra que te doy"));
        addUser(new User(1, "Maria", "carmen.mario@gmail.com", "12345234", "La que se fue"));
    }
}
