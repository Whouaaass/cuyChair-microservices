package co.edu.unicauca.cuychair.gui.gui.Context;

import co.edu.unicauca.cuychair.gui.gui.DTO.UserDTO;
import co.edu.unicauca.cuychair.gui.gui.services.ConferenceServices;
import co.edu.unicauca.cuychair.gui.gui.services.PaperServices;
import co.edu.unicauca.cuychair.gui.gui.services.UserServices;

public class AppContext {
    private static AppContext instance = new AppContext();

    //usuario logueado
    private UserDTO loggedUser;

    private ConferenceServices conferenceService;
    private PaperServices paperService;
    private UserServices userService;

    private AppContext() {
        this.conferenceService=new ConferenceServices();
        this.paperService=new PaperServices();
        this.userService=new UserServices();
    }

    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    public static AppContext init() {
        instance = new AppContext();
        return instance;
    }

    public UserDTO getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(UserDTO loggedUser) {
        this.loggedUser = loggedUser;
    }

    public ConferenceServices getConferenceService() {
        return conferenceService;
    }

    public PaperServices getPaperService() {
        return paperService;
    }

    public UserServices getUserService() {
        return userService;
    }
    
}
