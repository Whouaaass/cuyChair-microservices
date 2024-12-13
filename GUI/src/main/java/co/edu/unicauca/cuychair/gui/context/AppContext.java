package co.edu.unicauca.cuychair.gui.context;

import co.edu.unicauca.cuychair.gui.api.services.ConferenceServices;
import co.edu.unicauca.cuychair.gui.api.services.PaperReviewServices;
import co.edu.unicauca.cuychair.gui.api.services.PaperServices;
import co.edu.unicauca.cuychair.gui.api.services.UserServices;

/**
 * Clase que es un singleton que contiene los servicios de la aplicación
 */
public class AppContext {

    private static AppContext instance;

    private ConferenceServices conferenceServices;
    private PaperReviewServices paperReviewServices;
    private PaperServices paperServices;
    private UserServices userServices;

    private AppContext() {
        conferenceServices = new ConferenceServices();
        paperReviewServices = new PaperReviewServices();
        paperServices = new PaperServices();
        userServices = new UserServices();
    }

    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    public ConferenceServices getConferenceService() {
        return conferenceServices;
    }

    public PaperReviewServices getPaperReviewService() {
        return paperReviewServices;
    }

    public PaperServices getPaperService() {
        return paperServices;
    }

    public UserServices getUserService() {
        return userServices;
    }

}
