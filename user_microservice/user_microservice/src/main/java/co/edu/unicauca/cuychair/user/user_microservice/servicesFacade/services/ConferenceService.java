package co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import co.edu.unicauca.cuychair.user.user_microservice.dataAccess.repository.IConferenceRepository;
import co.edu.unicauca.cuychair.user.user_microservice.domain.ConferenceEntity;
import co.edu.unicauca.cuychair.user.user_microservice.rabbit.publisher.Publisher;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.user.user_microservice.servicesFacade.DTO.ConversorConferenceDTO;


@Slf4j
@Service
public class ConferenceService implements IConferenceService{
    @Autowired
    private IConferenceRepository conferenceRepository;
    private ConversorConferenceDTO conversorConferenceDTO;
    
    public ConferenceService(IConferenceRepository conferenceRepository){
        this.conferenceRepository = conferenceRepository;
        this.conversorConferenceDTO = new ConversorConferenceDTO();
    }
    
	@Autowired
	private Publisher publisher;
	//Metodo para enviar conferencia a rabiitMQ
	public ConferenceDTO sendConferenceToRabbit(int id) {	
        ConferenceDTO conferenceDTO=getConference(id);
		log.info("Message '{}'  Conference title: '{}' will be send ... ", conferenceDTO,conferenceDTO.getTitle());
		this.publisher.sendConferenceDTO(conferenceDTO);
        return conferenceDTO;
	}

    @Override
    public ConferenceDTO addConference(ConferenceDTO conferenceDTO) {
        ConferenceEntity conference =  conversorConferenceDTO.converseDTOInConference(conferenceDTO);
        conferenceDTO = conversorConferenceDTO.converseConferenceInDTO(conferenceRepository.addConference(conference));
        return conferenceDTO;
    }

    @Override
    public List<ConferenceDTO> listConferences() {
        List<ConferenceEntity> conferenceList = conferenceRepository.listConferences();
        List<ConferenceDTO> conferenceDTOList = conversorConferenceDTO.converseListInDTO(conferenceList);
        return conferenceDTOList;
    }

    @Override
    public ConferenceDTO updateConference(int id, ConferenceDTO conferenceDTO) {
        ConferenceEntity conferenceEntity = conversorConferenceDTO.converseDTOInConference(conferenceDTO);
        conferenceDTO = conversorConferenceDTO.converseConferenceInDTO(conferenceRepository.updateConference(id, conferenceEntity));
        return conferenceDTO;
    }

    @Override
    public ConferenceDTO getConference(int id) {
        ConferenceDTO conferenceDTO = conversorConferenceDTO.converseConferenceInDTO(conferenceRepository.getConference(id)); 
        return conferenceDTO;
    }

    @Override
    public ConferenceDTO getConferenceByOwner(int idOwner) {
        ConferenceDTO conferenceDTO = conversorConferenceDTO.converseConferenceInDTO(conferenceRepository.getConferenceByOwner(idOwner));
        return conferenceDTO;
    }

    @Override
    public ConferenceDTO deleteConference(int id) {
        ConferenceEntity conferenceEntity = conferenceRepository.deleteConference(id);
        ConferenceDTO conferenceDTO = conversorConferenceDTO.converseConferenceInDTO(conferenceEntity);
        return conferenceDTO; 
    }

    @Override
    public boolean conferenceExist(int id) {
        return conferenceRepository.conferenceExist(id);
    }

}
