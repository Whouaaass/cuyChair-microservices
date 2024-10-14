package co.edu.unicauca.cuychair.user.user_microservice.dataAccess.repository;

import java.util.List;

import co.edu.unicauca.cuychair.user.user_microservice.dataAccess.domain.ConferenceEntity;

public interface IConferenceRepository {
    public ConferenceEntity addConference(ConferenceEntity conference);
    public List<ConferenceEntity> listConferences();
    public ConferenceEntity updateConference(int id, ConferenceEntity conference);
    public ConferenceEntity getConference(int id);
    public ConferenceEntity getConferenceByOwner(int idOwner);
    public ConferenceEntity deleteConference(int id);
    public ConferenceEntity conferenceExist(int id);
}
