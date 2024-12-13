package co.edu.unicauca.cuychair.gui.context;

import co.edu.unicauca.cuychair.gui.domain.User;
import co.edu.unicauca.cuychair.gui.language.LanguageManager;


// TODO: mudar LanguageManager a AppContext
/**
 * Clase que es un singleton que contiene la información de la sesión actual del
 * usuario
 */
public class SessionContext {
    private static SessionContext instance;

    private User user;    
    private final LanguageManager languageManager;

    private SessionContext() {
        user = new User(
            4,
            "NoApi",
            "NoApi",
            "NoApi@mail.com",
            "norole"
        );        
        languageManager = new LanguageManager();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    /**
     * Obtiene una instancia del contexto de sesión
     * 
     * @return SessionContext instancia del contexto de sesión
     */
    public static SessionContext getInstance() {
        if (instance == null) {
            instance = new SessionContext();
        }
        return instance;
    }

    /**
     * Obtiene el id del usuario
     * 
     * @return String id del usuario
     */
    public Integer getUserId() {
        return user.getId();
    }

    /**
     * Establece el id del usuario
     * 
     * @param userId id del usuario
     */
    public void setUserId(Integer userId) {
        user.setId(userId);
    }

    /**
     * Obtiene el nombre del usuario
     * 
     * @return nombre del usuario
     */
    public String getUserName() {
        return String.format("%s %s", user.getName(), user.getLastName());
    }

    /**
     * Establece el nombre del usuario
     * 
     * @param userName nombre del usuario
     */
    public void setUserName(String userName) {
        user.setName(userName);
    }

    /**
     * Obtiene el rol del usuario
     * 
     * @return rol del usuario
     */
    public String getUserRole() {
        return user.getRol();
    }

    /**
     * Establece el rol del usuario
     * 
     * @param userRole rol del usuario
     */
    public void setUserRole(String userRole) {
        user.setRol(userRole);
    }


    /**
     * Obtiene el correo del usuario
     * 
     * @return correo del usuario
     */
    public String getUserMail() {
        return user.getEmail();
    }

    /**
     * Establece el correo del usuario
     * 
     * @param userMail correo del usuario
     */
    public void setUserMail(String userMail) {
        user.setEmail(userMail);
    }
    
    public LanguageManager getLanguageManager() {
        return languageManager;
    }
}
