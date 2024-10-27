package co.edu.unicauca.cuychair.user.user_microservice.rabbit.publisher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Binding;
@Configuration
public class PublisherConfig {
	
    @Value("${co.edu.unicauca.cuychair.user.userDTO.queue}")
    private String messageUserDTO;

    @Bean   
    public Queue userQueue() {
        return new Queue(messageUserDTO, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("exchangeUser");
    }

    @Bean
    public Binding binding(Queue myQueue, DirectExchange exchange) {
        return BindingBuilder.bind(myQueue).to(exchange).with("routingKey");
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

}

