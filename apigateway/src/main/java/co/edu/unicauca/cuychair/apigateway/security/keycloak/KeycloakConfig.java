package co.edu.unicauca.cuychair.apigateway.security.keycloak;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    @Value("${keycloak.server-url}")
    private String KEYCLOAK_URL;

    @Value("${keycloak.realm}")
    private String KEYCLOAK_REALM;

    @Value("${keycloak.client-id}")
    private String KEYCLOAK_CLIENT_ID;

    @Bean
    public Keycloak keycloak() {
        Logger Log = Logger.getLogger("KeycloakConfig");

        try {
            Keycloak keycloak = Keycloak.getInstance(
                    KEYCLOAK_URL,
                    KEYCLOAK_REALM,
                    "admin",
                    "admin",
                    KEYCLOAK_CLIENT_ID);
            RealmRepresentation realm = new RealmRepresentation();
            realm.setRealm("cuychair");
            realm.setEnabled(true);
            realm.setSslRequired("external");
            realm.setRegistrationAllowed(true);
            realm.setRegistrationEmailAsUsername(true);

            boolean realmExists = keycloak.realms().findAll().stream()
                    .anyMatch(r -> r.getRealm().equals("cuychair"));

            if (!realmExists) {
                // Create the realm if it doesn't exist
                keycloak.realms().create(realm);
                Log.info("Realm 'cuychair' created successfully.");
            } else {
                Log.warning("Realm 'cuychair' already exists.");
            }

            return keycloak;
        } catch (Exception e) {
            Log.log(Level.SEVERE, "Error initing keycloak: {0}", e.getMessage());
            return null;
        }
    }

}
