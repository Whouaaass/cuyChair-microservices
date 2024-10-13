package co.edu.unicauca.cuychair.paper_microservice.dataaccess;

import co.edu.unicauca.cuychair.paper_microservice.domain.Paper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RepositoryPaper implements IRepositoryPaper{
    private ArrayList<Paper> paperList;
    private AtomicInteger indexCounter;

    public RepositoryPaper() {
        this.paperList=new ArrayList<>();
        this.indexCounter= new AtomicInteger(0);
    }

    @Override
    public boolean storePaper(Paper objPaper) {
        objPaper.setId(indexCounter.getAndIncrement());
        return paperList.add(objPaper);
    }

    @Override
    public boolean delatePaper(Paper objPaper) {
        return paperList.remove(objPaper);
    }

    @Override
    public List<Paper> listPapers() {
        return paperList;
    }

}
