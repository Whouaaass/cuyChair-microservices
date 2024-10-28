package co.edu.unicauca.cuychair.conference_microservice.rabbit.publisher;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class PublisherConfig {   

    public static final String EXCHANGE_NAME = "CuyChairExchangeConference";
    public static final String ROUTING_KEY = "conference_updates";

    @Value("${co.edu.unicauca.cuychair.conference.queue}")
    private String messageConferenceDTO;

    @Bean(name="conferenceQueue")
    public Queue conferenceQueue() {
        return new Queue(messageConferenceDTO, true);
    }

    @Bean(name="conferenceExchange")
    public DirectExchange conferenceExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean(name="conference")
    public Binding binding(@Qualifier("conferenceQueue") Queue conferenceQueue, @Qualifier("conferenceExchange") DirectExchange exchange) {
        return BindingBuilder.bind(conferenceQueue).to(exchange).with(ROUTING_KEY);
    }

}

