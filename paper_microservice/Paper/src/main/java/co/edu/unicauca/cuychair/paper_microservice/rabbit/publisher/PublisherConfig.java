package co.edu.unicauca.cuychair.paper_microservice.rabbit.publisher;


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

    private final boolean DURABLE = true;

    @Value("${cuychair.rabbitmq.exchange.paper}")
    private String EXCHANGE_NAME;
    @Value("${cuychair.rabbitmq.exchange.paper.routingkey}")
    private String ROUTING_KEY;        
    
    @Value("${cuychair.rabbitmq.queue.paper.paper}")
    private String PAPER_QUEUE;

    @Value("${cuychair.rabbitmq.queue.paper.review}")
    private String REVIEW_QUEUE;
    

    @Bean(name="paperExchange")
    public DirectExchange conferenceExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean(name="paperQueue")
    public Queue paperQueue() {
        return new Queue(PAPER_QUEUE, DURABLE);
    }

    @Bean(name="paperBinding")
    public Binding paperBinding(@Qualifier("paperQueue") Queue queue, @Qualifier("paperExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean(name="reviewQueue")
    public Queue reviewQueue() {
        return new Queue(REVIEW_QUEUE, DURABLE);
    }

    @Bean(name="reviewBinding")
    public Binding reviewBinding(@Qualifier("reviewQueue") Queue queue, @Qualifier("paperExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

}
