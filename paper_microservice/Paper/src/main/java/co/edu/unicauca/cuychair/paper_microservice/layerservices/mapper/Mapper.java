package co.edu.unicauca.cuychair.paper_microservice.layerservices.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    @Bean
    public ModelMapper modelMaper(){
        return new ModelMapper();
    }
}
