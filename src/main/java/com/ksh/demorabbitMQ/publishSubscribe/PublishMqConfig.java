package com.ksh.demorabbitMQ.publishSubscribe;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublishMqConfig {

    public static final String QUEUE_PUBLISH_ONE = "queue.publish.one";
    public static final String QUEUE_PUBLISH_TWO = "queue.publish.two";
    public static final String QUEUE_PUBLISH_THREE = "queue.publish.three";
    public static final String PUBLISH_EXCHANGE = "publishExchange";

    /**
     * 创建队列，指定队列名称
     */
    @Bean
    public Queue queuePublishOne() {
        return new Queue(QUEUE_PUBLISH_ONE, true);
    }

    @Bean
    public Queue queuePublishTwo() {
        return new Queue(QUEUE_PUBLISH_TWO, true);
    }

    @Bean
    public Queue queuePublishThree() {
        return new Queue(QUEUE_PUBLISH_THREE, true);
    }

    /**
     * 创建交换器
     * 扇出交换机,将接收到的消息路由到所有绑定的队列。
     * 消息的routing key将被忽略,所有绑定的队列都会收到消息。
     */
    @Bean
    public FanoutExchange publishExchange() {
        return new FanoutExchange(PUBLISH_EXCHANGE);
    }

    /**
     * 绑定队列到交换机(不用指定routing key),参数名字要和bean名字一致
     */
    @Bean
    public Binding bindingPublishOne(Queue queuePublishOne, FanoutExchange publishExchange) {
        return BindingBuilder.bind(queuePublishOne).to(publishExchange);
    }

    @Bean
    public Binding bindingPublishTwo(Queue queuePublishTwo, FanoutExchange publishExchange) {
        return BindingBuilder.bind(queuePublishTwo).to(publishExchange);
    }

    @Bean
    public Binding bindingPublishThree(Queue queuePublishThree, FanoutExchange publishExchange) {
        return BindingBuilder.bind(queuePublishThree).to(publishExchange);
    }
}
