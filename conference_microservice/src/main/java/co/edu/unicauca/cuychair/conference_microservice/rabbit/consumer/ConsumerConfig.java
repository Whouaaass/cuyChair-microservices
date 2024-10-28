package co.edu.unicauca.cuychair.conference_microservice.rabbit.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

    @Value("${co.edu.unicauca.cuychair.user.conference.queue}")
    private String messageUserDTO;

    @Bean(name="userQueue")
    public Queue userQueue() {
        return new Queue(messageUserDTO, true);
    }
    @Bean(name="userExchange")
    public DirectExchange exchange() {
        return new DirectExchange("exchangeUser");
    }
    @Bean(name="userBind")
    public Binding binding(@Qualifier("userQueue") Queue myQueue, @Qualifier("userExchange") DirectExchange exchange) {
        return BindingBuilder.bind(myQueue).to(exchange).with("routingKey");
    }
    
}
