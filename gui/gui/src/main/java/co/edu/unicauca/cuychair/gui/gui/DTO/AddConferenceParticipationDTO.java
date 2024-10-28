package co.edu.unicauca.cuychair.gui.gui.DTO;



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
