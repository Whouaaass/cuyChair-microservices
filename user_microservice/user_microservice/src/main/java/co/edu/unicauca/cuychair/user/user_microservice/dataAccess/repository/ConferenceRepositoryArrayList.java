package co.edu.unicauca.cuychair.user.user_microservice.dataAccess.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import co.edu.unicauca.cuychair.user.user_microservice.dataAccess.domain.ConferenceEntity;

public class ConferenceRepositoryArrayList implements IConferenceRepository{
    private ArrayList<ConferenceEntity> conferenceList;
    private AtomicInteger idCounter;
    public ConferenceRepositoryArrayList(){
        this.idCounter = new AtomicInteger(1);
        conferenceList = new ArrayList<ConferenceEntity>();
        uploadDefaultData();
    }

    private void uploadDefaultData() {
        ConferenceEntity conference1 = new ConferenceEntity();//TODO
    }

    @Override
    public ConferenceEntity addConference(ConferenceEntity conference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addConference'");
    }

    @Override
    public List<ConferenceEntity> listConferences() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listConferences'");
    }

    @Override
    public ConferenceEntity updateConference(int id, ConferenceEntity conference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateConference'");
    }

    @Override
    public ConferenceEntity getConference(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConference'");
    }

    @Override
    public ConferenceEntity getConferenceByOwner(int idOwner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConferenceByOwner'");
    }

    @Override
    public ConferenceEntity deleteConference(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteConference'");
    }

    @Override
    public ConferenceEntity conferenceExist(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'conferenceExist'");
    }
    
}
