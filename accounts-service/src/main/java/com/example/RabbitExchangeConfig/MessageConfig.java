package com.example.RabbitExchangeConfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessageConfig {

    public static final String QUEUE = "account_queue";
    public static final String EXCHANGE = "account_exchange";
    public static final String ROUTING_KEY = "account_routingKey";

    public static final String QUEUE_NOTIFICATION = "notification_queue";

    public static final String EXCHANGE_NOTIFICATION = "notification_exchange";

    public static final String ROUTING_KEY_NOTIFICATION = "notification_routingKey";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_NOTIFICATION);
    }

    @Bean
    public TopicExchange exchange1() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public TopicExchange exchange2() {
        return new TopicExchange(EXCHANGE_NOTIFICATION);
    }

    @Bean
    public Binding binding1(Queue queue1, TopicExchange exchange1) {
        return BindingBuilder.bind(queue1).to(exchange1).with(ROUTING_KEY);
    }

    @Bean
    public Binding binding2(Queue queue2, TopicExchange exchange2) {
        return BindingBuilder.bind(queue2).to(exchange2).with(ROUTING_KEY_NOTIFICATION);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
