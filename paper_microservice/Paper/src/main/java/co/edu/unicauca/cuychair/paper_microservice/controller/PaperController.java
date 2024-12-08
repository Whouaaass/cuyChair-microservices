package co.edu.unicauca.cuychair.paper_microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorPaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.controller.mapper.ConversorUserDTO;
import co.edu.unicauca.cuychair.paper_microservice.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.ConferenceStoreService;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.PaperStoreService;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.UserStoreService;

@RestController
@RequestMapping("/api")
public class PaperController {
    @Autowired
    private  PaperStoreService servicePaper;
    @Autowired
    private  ConferenceStoreService serviceConference;
    @Autowired
    private  UserStoreService serviceUser;


    private ConversorPaperDTO maperPaper;
    private ConversorConferenceDTO maperConference;
    private ConversorUserDTO maperUser;

    public PaperController() {
        this.maperPaper = new ConversorPaperDTO();
        this.maperConference = new ConversorConferenceDTO();
        this.maperUser = new ConversorUserDTO();
    }

    /**
     * @brief Guardar un Paper
     * @param objPaper Paper a guardar
     * @return Confirmación
     */
    @PostMapping("/paper")
    public PaperDTO storePaper (@RequestBody PaperDTO objPaper){
        Paper paper=maperPaper.toPaper(objPaper,serviceUser.getUserById(objPaper.getIdAuthor()),serviceConference.getConferenceById(objPaper.getIdConference()));
        return maperPaper.toPaperDTO(servicePaper.storePaper(paper));
    }
    /**
     * @brief Eliminar un Paper
     * @param objPaper Paper a eliminar
     * @return Paper eliminado
     */

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public PaperDTO delatePaper (@RequestBody PaperDTO objPaper){
        Paper paper=maperPaper.toPaper(objPaper,serviceUser.getUserById(objPaper.getIdAuthor()),serviceConference.getConferenceById(objPaper.getIdConference()));
        return maperPaper.toPaperDTO(servicePaper.delatePaper(paper));
    }

    /**
     * @brief listar los Paper
     * @return lista de todos los paper
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<PaperDTO> listPapers (){
        return maperPaper.toPaperDTOList(servicePaper.listPapers());
    }

    @PostMapping("/user")
    public UserDTO addUser(@RequestBody UserDTO objUser){
        User user=maperUser.toUser(objUser);
        return maperUser.toUserDTO(serviceUser.addUser(user));
    }

    @PostMapping("/conference")
    public ConferenceDTO addConference(@RequestBody ConferenceDTO objConference){
        Conference conference=maperConference.toConference(objConference);
        return maperConference.toConferenceDTO(serviceConference.addConference(conference));
    }

    @PutMapping("/edit")
    public PaperDTO editPaper(@RequestBody PaperDTO objPaper){
        Paper paper=maperPaper.toPaper(objPaper,serviceUser.getUserById(objPaper.getIdAuthor()),serviceConference.getConferenceById(objPaper.getIdConference()));
        return maperPaper.toPaperDTO(servicePaper.editPaper(paper));
    }

    @GetMapping("/paperAuthor/{authorId}")
    public List<PaperDTO> getPapersByAuthor (@PathVariable int authorId){
        return maperPaper.toPaperDTOList(servicePaper.getPaperByAuthor(authorId));
    }

    @GetMapping("/listconferences/{Userid}")
    public List<Integer> listConferencesByUser (@PathVariable int Userid){
        return serviceConference.conferencesParticipanUser(serviceUser.getUserById(Userid));
    }

    @GetMapping("/clonePaper/{PaperId}")
    public PaperDTO clonePaper (@PathVariable int PaperId){
        return maperPaper.toPaperDTO(servicePaper.clonePaper(PaperId));
    }
}
