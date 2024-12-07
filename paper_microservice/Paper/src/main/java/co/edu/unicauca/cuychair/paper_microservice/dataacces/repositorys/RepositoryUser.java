package co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Objects;

@Repository
public class RepositoryUser implements IRepositoryUser {

    private ArrayList<User> listUser;

    public RepositoryUser() {
        this.listUser = new ArrayList<>();
    }

    @Override
    public User addUser(User objUser) {
        if(listUser.add(objUser)) {
            return objUser;
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        for(User us:listUser){
            if(Objects.equals(us.getId(), id)){
                return us;
            }
        }
        return null;
    }
}
