package co.edu.unicauca.cuychair.paper_microservice.dataaccess;

import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;

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
}
