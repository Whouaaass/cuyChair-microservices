package co.edu.unicauca.cuychair.api_gateway.controller;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

@Bean
public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                // Ruta para user_microservice
                .route("user_microservice", r -> r.path("/api/user/**")
                .uri("http://localhost:8091")) 

                // Ruta para conference_microservice
                .route("conference_microservice", r -> r.path("/api/conference/**")
                .uri("http://localhost:8092")) 

                // Ruta para paperreview_microservice
                .route("paperreview_microservice", r -> r.path("/paperReview/**")
                .uri("http://localhost:8093")) // Cambia al puerto de tu microservicio de paper review

                // Rutas para paper_microservice
                .route("paper_microservice", r -> r.path("/api/paper/**", "/api/listconferences/**", "/api/clonePaper/**", "/api/edit/**")
                .uri("http://localhost:8094")) 


                .build();
        }
}
