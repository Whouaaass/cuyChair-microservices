package co.edu.unicauca.cuychair.conference_microservice.domain.services;

import co.edu.unicauca.cuychair.conference_microservice.domain.models.Conference;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.Paper;
import co.edu.unicauca.cuychair.conference_microservice.domain.models.User;

public class ConferenceRelations {

    public ConferenceRelations() {}


    public static boolean addAuthor(Conference conference, User participant) {        
        if (conference == null || participant == null) {
            return false;
        }        
        conference.addAuthor(participant);
        participant.addAuthorConference(conference);        
        return true;
    }

    public static boolean addReviewer(Conference conference, User participant) {
        if (conference == null || participant == null) {
            return false;
        }        
        conference.addReviewer(participant);
        participant.addReviewerConference(conference); 
        return true;
    }

    public static boolean removeAuthor(Conference conference, User participant) {
        if (conference == null || participant == null) {
            return false;
        }
        conference.removeAuthor(participant);
        participant.removeAuthorConference(conference);
        return true;
    }

    public static boolean removeReviewer(Conference conference, User participant) {
        if (conference == null || participant == null) {
            return false;
        }
        conference.removeReviewer(participant);
        participant.removeReviewerConference(conference);
        return true;
    }


    public static boolean addChair(Conference conference, User participant) {
        if (conference == null || participant == null) {
            return false;
        }
        conference.setChair(participant);
        return true;
    }

    public static boolean addPaper(Conference conference, Paper paper) {
        if (conference == null || paper == null) {
            return false;
        }
        paper.setConference(conference);
        conference.addPaper(paper);
        return true;
    }
    
}
