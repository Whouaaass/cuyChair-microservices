package co.edu.unicauca.cuychair.user.user_microservice.dataAccess.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.user.user_microservice.domain.UserEntity;

@Repository
public class UserRepositoryArrayList implements IUserRepository{
    private ArrayList<UserEntity> userList;
    
    
    public UserRepositoryArrayList(){
        this.userList = new ArrayList<UserEntity>();
        uploadDefaultData();
    }

    private void uploadDefaultData() {
        UserEntity user1 = new UserEntity(1000,"Juan","Meneses","juanMeneses@gmail.com","Contrasima123","Un tipo ramdom1",310382822);
        UserEntity user2 = new UserEntity(1001,"Juliano","Manino","julianoMan@gmail.com","1234oasm","Un tipo ramdom2",31032822);
        UserEntity user3 = new UserEntity(1002,"Cristiano","Ronaldo","cr7@gmail.com","Siu123","Un tipo muy ramdom1",310382812);
        UserEntity user4 = new UserEntity(1003,"Lionel","Messi","messi10@gmail.com","miraVoh123","Un tipo no tan ramdom2",31024822);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
    }

    private int getIdx(int id) {
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        userList.add(user);
        return userList.getLast();
    }

    @Override
    public List<UserEntity> listUsers() {
        return userList;
    }    

    @Override
    public UserEntity getUser(int id) {
        return userList.get(getIdx(id));
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getEmail().equals(email)){
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public UserEntity updateUser(int id, UserEntity user) {
        return userList.set(getIdx(id), user);
    }

    @Override
    public UserEntity deleteUser(int id) {
        return userList.remove(getIdx(id));
    }

    @Override
    public boolean userExist(int id) {
        return (getIdx(id)!=-1);
    }
    
}
