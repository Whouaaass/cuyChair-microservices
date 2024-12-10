package co.edu.unicauca.cuychair.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {

    private static final String USER_MICROSERVICE = "http://localhost:8091";
    private static final String CONFERENCE_MICROSERVICE = "http://localhost:8092";
    private static final String PAPERREVIEW_MICROSERVICE = "http://localhost:8093";
    private static final String PAPER_MICROSERVICE = "http://localhost:8094";
    
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            // Ruta para user_microservice
            .route("user_microservice", r -> r.path("/api/user/**")
            .uri(USER_MICROSERVICE))

                // Ruta para conference_microservice
            .route("conference_microservice", r -> r.path("/api/conference/**")
            .uri(CONFERENCE_MICROSERVICE))

            // Ruta para paperreview_microservice
            .route("paperreview_microservice", r -> r.path("/paperReview/**")
            .uri(PAPERREVIEW_MICROSERVICE)) // Cambia al puerto de tu microservicio de paper review

            // Rutas para paper_microservice
            .route("paper_microservice", r -> r.path("/api/paper/**", "/api/listconferences/**", "/api/clonePaper/**", "/api/edit/**")
            .uri(PAPER_MICROSERVICE))
            .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}
