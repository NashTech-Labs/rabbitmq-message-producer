package com.knoldus.rabbitMQ.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * General configuration of the application.
 *
 * @author Navdeep parash
 */
@ComponentScan(basePackages = {
        "com.knoldus.feedservice",
})

@Configuration
public class FeedMessagingConfig {

    public static final String FEED_QUEUE = "feed_queue";
    public static final String FEED_EXCHANGE = "feed_exchange";
    public static final String FEED_ROUTING_KEY = "feed_routingKey";

    @Bean
    public Queue feedqueue() {
        return new Queue(FEED_QUEUE);
    }

    @Bean
    public TopicExchange feedexchange() {
        return new TopicExchange(FEED_EXCHANGE );
    }

    @Bean
    public Binding feedbinding(Queue feedqueue, TopicExchange feedexchange) {
        return BindingBuilder.bind(feedqueue).to(feedexchange).with(FEED_ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}

