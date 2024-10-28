package co.edu.unicauca.cuychair.conference_microservice.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class messageQueueName {

    @Value("${co.edu.unicauca.cuychair.user.conference.queue}")
    private String conferenceQueueName;

    @Value("${co.edu.unicauca.cuychair.user.conference.queue}")
    private String messageUserDTO;

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }    

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }    

    @Bean(name = "conference")
    public Queue conferenceQueue() {
        return new Queue(conferenceQueueName, true);
    }

    @Bean(name = "conference")
    public DirectExchange conferenceExchange() {
        return new DirectExchange("CuyChairExchangeConference");
    }

    @Bean(name = "conference")
    public Binding bindingExchange(@Qualifier("conference") Queue conferenceQueue, @Qualifier("conference") DirectExchange exchange) {
        return BindingBuilder.bind(conferenceQueue).to(exchange).with("routingKey");
    }    

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
}
