package co.edu.unicauca.cuychair.user.user_microservice.dataAccess.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.cuychair.user.user_microservice.dataAccess.domain.ConferenceEntity;
import co.edu.unicauca.cuychair.user.user_microservice.dataAccess.domain.UserEntity;

@Repository
public class ConferenceRepositoryArrayList implements IConferenceRepository{
    private ArrayList<ConferenceEntity> conferenceList;
    private AtomicInteger idCounter;
    public ConferenceRepositoryArrayList(){
        this.idCounter = new AtomicInteger(1);
        conferenceList = new ArrayList<ConferenceEntity>();
        uploadDefaultData();
    }

    private void uploadDefaultData() {
        //Usuarios admin de prueba
        UserEntity user1 = new UserEntity(1000,"Juan","Meneses","juanMeneses@gmail.com","Contrasima123","Un tipo ramdom1",310382822);
        UserEntity user2 = new UserEntity(1001,"Juliano","Manino","julianoMan@gmail.com","1234oasm","Un tipo ramdom2",31032822);
        //Conferencias de prueba
        ConferenceEntity conference1 = new ConferenceEntity(100,"Hackaton","Cali","2025/08/20",null,user1);
        ConferenceEntity conference2 = new ConferenceEntity(101,"Matematicon","Bogotá","2024/12/20",null,user2);
        //Añadimos conferencias
        conferenceList.add(conference1);
        conferenceList.add(conference2);
    }

    private int getIdx(int id) {
        for(int i=0;i<conferenceList.size();i++){
            if(conferenceList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ConferenceEntity addConference(ConferenceEntity conference) {
        conference.setId(idCounter.incrementAndGet());
        conferenceList.add(conference);
        return conferenceList.getLast();
    }

    @Override
    public List<ConferenceEntity> listConferences() {
        return conferenceList;
    }

    @Override
    public ConferenceEntity updateConference(int id, ConferenceEntity conference) {
        return conferenceList.set(getIdx(id), conference);
    }

    @Override
    public ConferenceEntity getConference(int id) {
        return conferenceList.get(getIdx(id));
    }

    @Override
    public ConferenceEntity getConferenceByOwner(int idOwner) {
        for(int i=0;i<conferenceList.size();i++){
            if(conferenceList.get(i).getOwner().getId()==idOwner){
                return conferenceList.get(i);
            }
        }
        return null;
    }

    @Override
    public ConferenceEntity deleteConference(int id) {
        return conferenceList.remove(getIdx(id));
    }

    @Override
    public boolean conferenceExist(int id) {
        return (conferenceList.get(getIdx(id))!=null);
    }
}
