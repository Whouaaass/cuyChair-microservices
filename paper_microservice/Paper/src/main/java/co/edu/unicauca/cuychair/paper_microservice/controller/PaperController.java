package co.edu.unicauca.cuychair.paper_microservice.controller;

import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.ConferenceStoreService;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.PaperStoreService;
import co.edu.unicauca.cuychair.paper_microservice.servicesfacade.services.UserStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Paper")
public class PaperController {
    private final PaperStoreService servicePaper;
    private final ConferenceStoreService serviceConference;
    private final UserStoreService serviceUser;

    @Autowired
    public PaperController(PaperStoreService service, ConferenceStoreService serviceConference, UserStoreService serviceUser){
        this.servicePaper =service;
        this.serviceConference = serviceConference;
        this.serviceUser = serviceUser;
    }

    /**
     * @brief Guardar un Paper
     * @param objPaper Paper a guardar
     * @return Confirmación
     */
    @PostMapping("/paper")
    public boolean storePaper (@RequestBody PaperDTO objPaper){
        return servicePaper.storePaper(objPaper);
    }
    /**
     * @brief Eliminar un Paper
     * @param objPaper Paper a eliminar
     * @return Paper eliminado
     */

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public boolean delatePaper (@RequestBody PaperDTO objPaper){
        return servicePaper.delatePaper(objPaper);
    }

    /**
     * @brief listar los Paper
     * @return lista de todos los paper
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Paper> listPapers (){
        return servicePaper.listPapers();
    }

    @PostMapping("/user")
    public boolean addConferece(@RequestBody UserDTO objUser){
         return serviceUser.addUser(objUser);
    }

    @PostMapping("/conference")
    public boolean addConference(@RequestBody ConferenceDTO objConference){
        return serviceConference.addConference(objConference);
    }

    @PostMapping("/edit")
    public PaperDTO editPaper(@RequestBody PaperDTO objPaper){
        return servicePaper.editPaper(objPaper);
    }

    @GetMapping("/paperAuthor/{authorId}")
    public List<PaperDTO> getPapersByAuthor (@PathVariable int authorId){
        return servicePaper.getPaperByAuthor(authorId);
    }
}
