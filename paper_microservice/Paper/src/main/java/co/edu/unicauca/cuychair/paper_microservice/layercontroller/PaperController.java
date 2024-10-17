package co.edu.unicauca.cuychair.paper_microservice.layercontroller;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Conference;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.ConferenceDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.PaperDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO.UserDTO;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.services.ConferenceStoreService;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.services.PaperStoreService;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.services.UserStoreService;
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
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
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
}
