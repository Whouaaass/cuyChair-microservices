package co.edu.unicauca.cuychair.gui.language;

import java.util.ArrayList;


/**
 * Clase que se encarga de gestionar el idioma de la aplicación
 * Implementa el patrón Singleton
 */
public class LanguageManager {
    private LanguageLoader loader;
    private String language;

    private final ArrayList<Languagable> subscribers;

    public LanguageManager() {
        this.language = "es";
        this.loader = new LanguageLoader(language);
        this.subscribers = new ArrayList<>();
    }

    /**
     * Establece el idioma de la aplicación
     * @param language idioma a establecer, por ejemplo: "en", "es"
     */
    public void setLanguage(String language) {
        this.language = language;
        this.loader = new LanguageLoader(language);           
    }

    /**
     * Obtiene el idioma de la aplicación
     * @return
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Obtiene una cadena de texto en el idioma establecido
     * @param key
     * @return
     */
    public String getString(String key) {
        return loader.getString(key);
    }

    /**
     * Actualiza el idioma de la aplicación
     */
    public void updateLanguage() {
        loader = new LanguageLoader(language);
    }

    /**
     * Suscribe un objeto a los cambios de idioma
     * @param obj
     */
    public void subscribe(Languagable obj) {
        subscribers.add(obj);
    }
}
