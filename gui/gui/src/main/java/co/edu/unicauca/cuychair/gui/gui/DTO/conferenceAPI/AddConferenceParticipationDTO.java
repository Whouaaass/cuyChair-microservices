package co.edu.unicauca.cuychair.gui.gui.DTO.conferenceAPI;


/**
 * Dto usado para añadir una participacion de un usuario en una conferencia (El rol se deduce por el método usado)
 */
public class AddConferenceParticipationDTO {
    private Integer conferenceId;
    private Integer userId;
    

    public AddConferenceParticipationDTO() {}

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
