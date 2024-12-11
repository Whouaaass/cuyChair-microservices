package co.edu.unicauca.cuychair.paper_microservice.dataacces.repositorys;

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
        this.indexCounter= new AtomicInteger(1);
    }

    @Override
    public Paper storePaper(Paper objPaper) {
        objPaper.setId(indexCounter.getAndIncrement());
        if(objPaper.getAuthor()==null || objPaper.getConference()==null){
            return null;
        }
        if(!objPaper.getConference().getAuthors().contains(objPaper.getAuthor())){
            return null;
        }
        paperList.add(objPaper);
        return paperList.getLast();
    }

    @Override
    public Paper delatePaper(Paper objPaper) {
        paperList.remove(objPaper);
        return objPaper;
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

    @Override
    public Paper existPaper(int id) {
        for(Paper o:paperList){
            if(o.getId()==id){
                return o;
            }
        }
        return null;
    }


}
