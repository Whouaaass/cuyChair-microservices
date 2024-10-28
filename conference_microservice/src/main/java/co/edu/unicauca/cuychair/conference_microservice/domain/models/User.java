package co.edu.unicauca.cuychair.conference_microservice.domain.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {
    private @NonNull Integer id; // aqui el id no es utlizado pero se supone se debe de utilizar despues al crear cosas relacionales y además siempre no esta de más tener un id identificador del usuario porque siempre facilita su diferenciacion
    private @NonNull String name;
    private @NonNull String email;
    private @NonNull String phone;
    private @NonNull String description;

    private final Map<Integer, Conference> authorConferences = new HashMap<>();    
    private final Map<Integer, Conference> reviewedConferences = new HashMap<>();  

    public User() {}

    // id
    public void setId(Integer id) {
        this.id = id;
    }
    
    // name
    public void setName(String name) {
        this.name = name;
    }

    // email
    public void setEmail(String email) {
        this.email = email;
    }

    // phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // description
    public void setDescription(String description) {
        this.description = description;
    }

    // reviewerConferences
    public List<Conference> getReviewedConferences() {
        return List.copyOf(this.reviewedConferences.values());
    }
    public void addReviewerConference(Conference conference) {
        if (conference == null) return;
        this.reviewedConferences.put(conference.getId(), conference);
    }   
    public void removeReviewerConference(Conference conference) {
        if (conference == null) return;
        this.reviewedConferences.remove(conference.getId());
    }

    // authorConferences
    public ArrayList<Conference> getAuthorConferences() {
        return new ArrayList<>(this.authorConferences.values());
    }
    public void addAuthorConference(Conference conference) {
        if (conference == null) return;
        this.authorConferences.put(conference.getId(), conference);
    }
    public void removeAuthorConference(Conference conference) {
        this.authorConferences.remove(conference.getId());
    }    

}
