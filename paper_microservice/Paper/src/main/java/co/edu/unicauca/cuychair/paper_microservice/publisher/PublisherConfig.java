package co.edu.unicauca.cuychair.paper_microservice.publisher;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class PublisherConfig {
    public static final String EXCHANGE_NAME = "CuyChairExchangePaper";
    public static final String ROUTING_KEY = "paper_updates";

    //Cola de publicacion
    @Value("paper_microservice_paperDTO_queue")
    private String messagePaper;

    @Bean(name="paperQueue")
    public Queue queuePaper(){
        return new Queue(messagePaper,true);
    }

    @Bean(name="paperExchange")
    public DirectExchange conferenceExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean(name="paper")
    public Binding binding(@Qualifier("paperQueue") Queue paperQueue, @Qualifier("paperExchange") DirectExchange exchange) {
        return BindingBuilder.bind(paperQueue).to(exchange).with(ROUTING_KEY);
    }
}
