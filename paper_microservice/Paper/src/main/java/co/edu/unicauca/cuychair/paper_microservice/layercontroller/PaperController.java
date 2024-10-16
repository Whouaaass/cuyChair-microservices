package co.edu.unicauca.cuychair.paper_microservice.layercontroller;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.layerservices.services.PaperStoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Paper")
public class PaperController {
    private final PaperStoreService service;


    public PaperController(PaperStoreService service){
        this.service=service;
    }

    /**
     * @brief Guardar un Paper
     * @param objPaper Paper a guardar
     * @return Confirmación
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean storePaper (@RequestBody Paper objPaper){
        return service.storePaper(objPaper);
    }
    /**
     * @brief Eliminar un Paper
     * @param objPaper Paper a eliminar
     * @return Paper eliminado
     */

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public boolean delatePaper (@RequestBody Paper objPaper){
        return service.delatePaper(objPaper);
    }

    /**
     * @brief listar los Paper
     * @return lista de todos los paper
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Paper> listPapers (){
        return service.listPapers();
    }
}
