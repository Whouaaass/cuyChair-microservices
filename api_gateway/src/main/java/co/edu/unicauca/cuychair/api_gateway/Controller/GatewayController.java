package co.edu.unicauca.cuychair.api_gateway.Controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

@RestController
public class GatewayController{
    @GetMapping("/api")
    public String api(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient, WebSession session){
        return "API Gateway";
    }
}
