package co.edu.unicauca.cuychair.conference_microservice.domain.models;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Conference {

    // properties
    @NonNull private Integer id;
    @NonNull private String name;
    @NonNull private String subject;
    @NonNull private String description;

    // relationships
    private User chair;
    private ArrayList<User> authors;
    private ArrayList<User> reviewers;
    private ArrayList<Paper> papers;    

    public Conference() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public void addAuthor(User author) {
        this.authors.add(author);
    }

    public void removeAuthor(User author) {
        this.authors.remove(author);
    }

    public void addReviewer(User reviewer) {
        this.reviewers.add(reviewer);
    }

    public void removeReviewer(User reviewer) {
        this.reviewers.remove(reviewer);
    }

    public void addPaper(Paper paper) {
        this.papers.add(paper);
    }

    public void removePaper(Paper paper) {
        this.papers.remove(paper);
    }

    public void setChair(User chair) {
        this.chair = chair;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthors(ArrayList<User> authors) {
        this.authors = authors;
    }

    public void setReviewers(ArrayList<User> reviewers) {
        this.reviewers = reviewers;
    }

    public void setPapers(ArrayList<Paper> papers) {
        this.papers = papers;
    }

}
