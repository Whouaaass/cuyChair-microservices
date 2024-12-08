package co.edu.unicauca.cuychair.conference_microservice.rabbit.publisher;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de RabbitMQ para publicar mensajes
 * aqui se declara el exchange, la cola y la relación entre ellos
 */
@Configuration
public class PublisherConfig {

    private final boolean DURABLE = false;

    @Value("${cuychair.rabbitmq.exchange.conference}")
    private String EXCHANGE_NAME;

    @Value("${cuychair.rabbitmq.exchange.conference.routingkey}")
    private String ROUTING_KEY;

    @Value("${cuychair.rabbitmq.queue.conference.conference}")
    private String CONFERENCE_QUEUE;

    @Value("${cuychair.rabbitmq.queue.conference.paper}")
    private String PAPER_QUEUE;

    @Value("${cuychair.rabbitmq.queue.conference.review}")
    private String REVIEW_QUEUE;

    @Bean(name = "conferenceExchange")
    public DirectExchange conferenceExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean(name = "conferenceQueue")
    public Queue conferenceQueue() {
        return new Queue(CONFERENCE_QUEUE, DURABLE);
    }

    @Bean(name = "conferenceBinding")
    public Binding conferenceBinding(
            @Qualifier("conferenceQueue") Queue queue,
            @Qualifier("conferenceExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean(name = "paperQueue")
    public Queue paperQueue() {
        return new Queue(PAPER_QUEUE, DURABLE);
    }

    @Bean(name = "paperBinding")
    public Binding paperBinding(
            @Qualifier("paperQueue") Queue queue,
            @Qualifier("conferenceExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean(name = "reviewQueue")
    public Queue reviewQueue() {
        return new Queue(REVIEW_QUEUE, DURABLE);
    }

    @Bean(name = "reviewBinding")
    public Binding reviewBinding(
            @Qualifier("reviewQueue") Queue queue,
            @Qualifier("conferenceExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

}
