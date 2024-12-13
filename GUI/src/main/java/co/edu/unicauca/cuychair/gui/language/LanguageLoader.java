
package co.edu.unicauca.cuychair.gui.language;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageLoader {

    /**
     * Path a la carpeta de idiomas (el path es relativo a la carpeta resources)
     */
    private static final String LAN_PROPERTIES_PATH = "languages/messages";

    private static ResourceBundle bundle;

    public LanguageLoader() {
        try {
            bundle = ResourceBundle.getBundle(LAN_PROPERTIES_PATH);
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo de idioma");            
        }
    }

    public LanguageLoader(String language) {
        this.setLanguage(language);
    }

    public final void setLanguage(String language) {        
        Locale locale = Locale.of(language);
        bundle = ResourceBundle.getBundle(LAN_PROPERTIES_PATH, locale);
    }

    public String getString(String key) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(key);    
        } catch (Exception e) {
            return null;
        }
        
    }
}