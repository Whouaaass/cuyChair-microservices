package co.edu.unicauca.cuychair.paper_microservice.layerdataacces.repositorys;

import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.Paper;
import co.edu.unicauca.cuychair.paper_microservice.layerdataacces.domain.User;
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
        if(objPaper.getAuthor()==null || objPaper.getConference()==null){
            return false;
        }
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

    @Override
    public Paper editPaper(Paper objPaper) {
        int index=paperList.indexOf(objPaper);
        paperList.set(index, objPaper);
        return objPaper;
    }

    @Override
    public List<Paper> getPapersByAuthor(int authorId) {
        List<Paper> papers=new ArrayList<>();
        for(Paper o:paperList){
            if(o.getAuthor().getId()==authorId){
                papers.add(o);
            }
        }
        return papers;
    }

}