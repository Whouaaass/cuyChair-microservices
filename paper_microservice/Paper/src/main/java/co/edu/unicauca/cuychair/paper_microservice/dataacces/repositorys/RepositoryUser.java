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
        int index=listUser.indexOf(objUser);
        if(index!=-1){
            if(isEquals(objUser,listUser.get(index))){
                listUser.remove(index);
                return objUser;
            }
            listUser.set(index,objUser);
            return objUser;
        }
        if(listUser.add(objUser)) {
            return objUser;
        }
        return null;
    }

    private boolean isEquals(User objUser1, User objUser2) {
        if(objUser1.getName().equals(objUser2.getName())
        && objUser1.getLastName().equals(objUser2.getLastName())
        && objUser1.getDescription().equals(objUser2.getDescription())
        && objUser1.getEmail().equals(objUser2.getEmail())) {
            return true;
        }
        return false;
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
