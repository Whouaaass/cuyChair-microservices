package co.edu.unicauca.cuychair.conference_microservice.domain.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Conference {

    // properties
    @NonNull private Integer id;
    @NonNull private String name;
    @NonNull private String city;
    @NonNull private Date date;
    @NonNull private String subject;
    @NonNull private String description;

    // relationships
    private Map<Integer, User> authors = new HashMap<>();
    private Map<Integer, User> reviewers = new HashMap<>();
    private Map<Integer, Paper> papers = new HashMap<>();    
    private User chair;
    

    public Conference() {}

    // id
    public void setId(Integer id) {
        this.id = id;
    }

    // city
    public void setCity(String city) {
        this.city = city;
    }

    // date
    public void setDate(Date date) {
        this.date = date;
    }
    
    // subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // description
    public void setDescription(String description) {
        this.description = description;
    }

    // name
    public void setName(String name) {
        this.name = name;
    }   

    // author
    public void addAuthor(User author) {
        if (author == null) return;
        this.authors.put(author.getId(), author);
    }
    public void removeAuthor(User author) {
        if (author == null) return;
        this.authors.remove(author.getId());
    }
    public ArrayList<User> getAuthors() {
        return new ArrayList<>(this.authors.values());
    }
    public void setAuthors(ArrayList<User> authors) {
        for (User author : authors) {
            if (author == null) continue;
            this.authors.put(author.getId(), author);
        }        
    }

    // reviewer
    public void addReviewer(User reviewer) {
        if (reviewer == null) return;
        this.reviewers.put(reviewer.getId(), reviewer);
    }
    public void removeReviewer(User reviewer) {
        if (reviewer == null) return;
        this.reviewers.remove(reviewer.getId());
    }
    public ArrayList<User> getReviewers() {
        return new ArrayList<>(this.reviewers.values());
    }
    public void setReviewers(ArrayList<User> reviewers) {        
        for (User reviewer : reviewers) {
            if (reviewer == null) continue;
            this.reviewers.put(reviewer.getId(), reviewer);
        }
    }

    // papers
    public void addPaper(Paper paper) {
        if (paper == null) return;
        this.papers.put(paper.getId(), paper);
    }    
    public void removePaper(Paper paper) {
        if (paper == null) return;
        this.papers.remove(paper.getId());
    }
    public ArrayList<Paper> getPapers() {
        return new ArrayList<>(this.papers.values());
    }
    public void setPapers(ArrayList<Paper> papers) {
        for (Paper paper : papers) {
            if (paper == null) continue;
            this.papers.put(paper.getId(), paper);
        }
    }


    // chair
    public void setChair(User chair) {
        this.chair = chair;
    }
    public Integer getChairId() {
        if (this.chair == null) {
            return null;
        }
        return this.chair.getId();
    }       
    
    // participants
    public ArrayList<User> getParticipants() {
        Set<User> participantsSet = new HashSet<>();
        participantsSet.addAll(this.reviewers.values());
        participantsSet.addAll(this.authors.values());

        return new ArrayList<>(participantsSet);
    }   

}
