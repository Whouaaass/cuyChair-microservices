package co.edu.unicauca.cuychair.apigateway.services.auth;

import java.util.Collections;
import java.util.Map;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Autowired
    private Keycloak keycloak;

    public boolean login(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();

        String tokenUrl = "http://localhost:8080/realms/"+realm+"/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "password");
        formData.add("client_id", clientId);
        // If your client is confidential, include the client secret
        //formData.add("client_secret", "your-client-secret");
        formData.add("username", username);
        formData.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    tokenUrl,
                    HttpMethod.POST,
                    request,
                    Map.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                // Return the access token and other details
                return true;
            } else {
                // Handle unsuccessful authentication
                return false;
            }
        } catch (HttpClientErrorException e) {
            // Handle errors like invalid credentials
            return false;
        } catch (Exception e) {
            // Handle other exceptions
            return false;
        }
    }

    public boolean signup(String username, String password, String email) {
        try {
            // Create user representation
            UserRepresentation user = new UserRepresentation();
            user.setUsername(username);
            user.setEmail(password);

            // Set user credentials
            CredentialRepresentation credential = new CredentialRepresentation();
            credential.setTemporary(false);
            credential.setType(CredentialRepresentation.PASSWORD);
            credential.setValue(password);

            user.setCredentials(Collections.singletonList(credential));

            // Create the user
            this.keycloak.realm(realm).users().create(user);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
