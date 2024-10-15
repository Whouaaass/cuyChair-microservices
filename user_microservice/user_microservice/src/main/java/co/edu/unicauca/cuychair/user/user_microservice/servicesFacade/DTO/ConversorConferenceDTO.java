package co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.cuychair.user.user_microservice.dataAccess.domain.ConferenceEntity;

public class ConversorConferenceDTO {
@Autowired
    private ModelMapper modelMapper;
    public ConversorConferenceDTO(){
        this.modelMapper = new ModelMapper();
    }

    public ConferenceDTO converseConferenceInDTO(ConferenceEntity conferenceEntity){
        ConferenceDTO conferenceDTO = modelMapper.map(conferenceEntity, ConferenceDTO.class);
        return conferenceDTO;
    }

    public ConferenceEntity converseDTOInConference(ConferenceDTO conferenceDTO){
        ConferenceEntity conferenceEntity = modelMapper.map(conferenceDTO, ConferenceEntity.class);
        return conferenceEntity;
    }

    public List<ConferenceDTO> converseListInDTO(List<ConferenceEntity> conferenceList){
        return modelMapper.map(conferenceList, new TypeToken<List<ConferenceDTO>>(){}.getType());
    }
}
