package co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.repositories;

<<<<<<< HEAD:paperReview_microservice/src/main/java/co/edu/unicauca/cuychair/paperreview/paperreview_microservice/adapters/output/repositories/PaperRepositoryAdapter.java
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entities.PaperEntity;
=======
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.entitis.PaperEntity;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.adapters.output.mapper.PaperRepositoryMaper;
>>>>>>> ec9fe43d46420ac8ba920c26f3e74b6feda685c6:paperReview_microservice/src/main/java/co/edu/unicauca/cuychair/paperreview/paperreview_microservice/adapters/output/repositoris/PaperRepositoryAdapter.java
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.domain.Paper;
import co.edu.unicauca.cuychair.paperreview.paperreview_microservice.ports.output.PaperRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaperRepositoryAdapter implements PaperRepositoryPort {
    private List<PaperEntity> papers;
    private PaperRepositoryMaper maper;

    @Override
    public Paper addPaper(Paper paper) {
        if(papers == null) {
            this.papers = new ArrayList<>();
            this.maper = new PaperRepositoryMaper();
        }
        papers.add(maper.toPaperEntity(paper));
        return paper;
    }

    @Override
    public Paper updatePaper(Paper paper) {
        int index = papers.indexOf(maper.toPaperEntity(paper));
        if(index == -1) {
            return null;
        }
        papers.set(index,maper.toPaperEntity(paper));
        return paper;
    }

    @Override
    public Paper removePaper(Paper paper) {
        papers.remove(maper.toPaperEntity(paper));
        return paper;
    }

    @Override
    public Paper findById(int id) {
<<<<<<< HEAD:paperReview_microservice/src/main/java/co/edu/unicauca/cuychair/paperreview/paperreview_microservice/adapters/output/repositories/PaperRepositoryAdapter.java
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

=======
        for(PaperEntity paper : papers) {
            if(paper.getId() == id) {
                return maper.toPaper(paper);
            }
        }
        return null;
    }
>>>>>>> ec9fe43d46420ac8ba920c26f3e74b6feda685c6:paperReview_microservice/src/main/java/co/edu/unicauca/cuychair/paperreview/paperreview_microservice/adapters/output/repositoris/PaperRepositoryAdapter.java
}