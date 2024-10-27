package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;

import java.util.List;

public interface IRepositoryPaper {
    /*
    * @brief Agregar un Paper
    * @param objPaper Paper a guardar
    * @return confirmación
    * */
    boolean storePaper (Paper objPaper);

    /*
     * @brief Eliminar un Paper
     * @param objPaper Paper a eliminar
     * @return confirmación
     * */
    boolean delatePaper (Paper objPaper);

    /*
     * @brief Listar los paper
     * @return lista de todos los paper
     * */
    List<Paper> listPapers();

    Paper editPaper (Paper objPaper);

    List<Paper> getPapersByAuthor (int authorId);


}