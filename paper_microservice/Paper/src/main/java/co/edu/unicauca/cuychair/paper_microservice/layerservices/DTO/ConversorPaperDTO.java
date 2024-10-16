package co.edu.unicauca.cuychair.paper_microservice.layerservices.DTO;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Paper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ConversorPaperDTO {
    @Autowired
    private ModelMapper modelMapper;

    public PaperDTO PaperinDTO (Paper paper){
        return modelMapper.map(paper, PaperDTO.class);
    }

    public Paper DTOinPaper(PaperDTO paperDTO){
        return modelMapper.map(paperDTO, Paper.class);
    }

    public List<PaperDTO> listPaperinDTO(List<Paper> papers){
        return modelMapper.map(papers, new TypeToken<List<PaperDTO>>() {}.getType());
    }

    public List<Paper> listDTOinPaper(List<PaperDTO> papers){
        return modelMapper.map(papers, new TypeToken<List<Paper>>() {}.getType());
    }
}
