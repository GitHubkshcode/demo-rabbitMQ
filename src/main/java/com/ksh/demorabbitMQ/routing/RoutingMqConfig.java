package com.ksh.demorabbitMQ.routing;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingMqConfig {

    public static final String QUEUE_ROUTING_ONE = "queue.routing.one";
    public static final String QUEUE_ROUTING_TWO = "queue.routing.two";
    public static final String QUEUE_ROUTING_THREE = "queue.routing.three";
    public static final String ROUTING_EXCHANGE = "routingExchange";
    public static final String ROUTING_KEY_1 = "1";
    public static final String ROUTING_KEY_2 = "2";
    public static final String ROUTING_KEY_3 = "3";

    /**
     * 创建队列，指定队列名称
     */
    @Bean
    public Queue queueRoutingOne() {
        return new Queue(QUEUE_ROUTING_ONE, true);
    }

    @Bean
    public Queue queueRoutingTwo() {
        return new Queue(QUEUE_ROUTING_TWO, true);
    }

    @Bean
    public Queue queueRoutingThree() {
        return new Queue(QUEUE_ROUTING_THREE, true);
    }

    /**
     * 创建交换器
     * 直接交换机,根据消息的routing key直接将消息路由到指定的队列。
     * 消息的routing key必须完全匹配队列的binding key,才会被路由到该队列。
     */
    @Bean
    public DirectExchange routingExchange() {
        return new DirectExchange(ROUTING_EXCHANGE);
    }

    /**
     * 通过routingKey绑定队列到交换机,参数名字要和bean名字一致
     */
    @Bean
    public Binding bindingRoutingOne(Queue queueRoutingOne, DirectExchange routingExchange) {
        return BindingBuilder.bind(queueRoutingOne).to(routingExchange).with(ROUTING_KEY_1);
    }

    @Bean
    public Binding bindingRoutingTwo(Queue queueRoutingTwo, DirectExchange routingExchange) {
        return BindingBuilder.bind(queueRoutingTwo).to(routingExchange).with(ROUTING_KEY_2);
    }

    @Bean
    public Binding bindingRoutingThree(Queue queueRoutingThree, DirectExchange routingExchange) {
        return BindingBuilder.bind(queueRoutingThree).to(routingExchange).with(ROUTING_KEY_3);
    }
}
