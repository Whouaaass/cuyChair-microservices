package co.edu.unicauca.cuychair.user.user_microservice.rabbit.publisher;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

/**
 * Aqui se configuran los exchanges y todas la colas que se van a usar en el exchange
 */
@Configuration
public class PublisherConfig {

    private boolean durable = true;

    @Value("${cuychair.rabbitmq.exchange.user}")
    private String USER_EXCHANGE;

    @Value("${cuychair.rabbitmq.exchange.user.routingkey}")
    private String USER_ROUTING_KEY;

    @Value("${cuychair.rabbitmq.queue.user.user}")
    private String USER_QUEUE;

    @Value("${cuychair.rabbitmq.queue.user.conference}")
    private String CONFERENCE_QUEUE;

    @Value("${cuychair.rabbitmq.queue.user.paper}")
    private String PAPER_QUEUE;

    @Value("${cuychair.rabbitmq.queue.user.review}")
    private String REVIEW_QUEUE;

    @Bean(name = "userExchange")
    public DirectExchange exchange() {
        return new DirectExchange(USER_EXCHANGE);
    }

    @Bean(name = "userQueue")
    public Queue userQueue() {
        return new Queue(USER_QUEUE, durable);
    }

    @Bean(name = "userBind")
    public Binding Bind(@Qualifier("userQueue") Queue UserQueue,
            @Qualifier("userExchange") DirectExchange UserExchange) {
        return BindingBuilder.bind(UserQueue).to(UserExchange).with(USER_ROUTING_KEY);
    }

    @Bean(name = "conferenceQueue")
    public Queue conferenceQueue() {
        return new Queue(CONFERENCE_QUEUE, durable);
    }

    @Bean(name = "conferenceBind")
    public Binding conferenceBind(@Qualifier("conferenceQueue") Queue ConferenceQueue,
            @Qualifier("userExchange") DirectExchange UserExchange) {
        return BindingBuilder.bind(ConferenceQueue).to(UserExchange).with(USER_ROUTING_KEY);
    }

    @Bean(name = "paperQueue")
    public Queue paperQueue() {
        return new Queue(PAPER_QUEUE, durable);
    }

    @Bean(name = "paperBind")
    public Binding paperBind(@Qualifier("paperQueue") Queue PaperQueue,
            @Qualifier("userExchange") DirectExchange UserExchange) {
        return BindingBuilder.bind(PaperQueue).to(UserExchange).with(USER_ROUTING_KEY);
    }

    @Bean(name = "reviewQueue")
    public Queue reviewQueue() {
        return new Queue(REVIEW_QUEUE, durable);
    }

    @Bean(name = "reviewBind")
    public Binding reviewBind(@Qualifier("reviewQueue") Queue ReviewQueue,
            @Qualifier("userExchange") DirectExchange UserExchange) {
        return BindingBuilder.bind(ReviewQueue).to(UserExchange).with(USER_ROUTING_KEY);
    }

}
