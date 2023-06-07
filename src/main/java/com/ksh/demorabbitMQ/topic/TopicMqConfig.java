package com.ksh.demorabbitMQ.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicMqConfig {
    public static final String QUEUE_TOPIC_ONE = "queue.topic.one";
    public static final String QUEUE_TOPIC_TWO = "queue.topic.two";
    public static final String QUEUE_TOPIC_THREE = "queue.topic.three";
    public static final String TOPIC_EXCHANGE = "topicExchange";

    @Bean
    public Queue queueTopicOne() {
        return new Queue(QUEUE_TOPIC_ONE, true);
    }

    @Bean
    public Queue queueTopicTwo() {
        return new Queue(QUEUE_TOPIC_TWO, true);
    }

    @Bean
    public Queue queueTopicThree() {
        return new Queue(QUEUE_TOPIC_THREE, true);
    }

    /**
     * 创建交换器
     * 主题交换机,将消息路由到符合routing pattern(路由模式)的队列。
     * 路由模式中的#:匹配一个或多个词
     * 路由模式中的*:匹配一个词
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    //绑定队列
    @Bean
    public Binding bindingTopicOne(Queue queueTopicOne, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopicOne).to(topicExchange).with("#.error");
    }

    @Bean
    public Binding bindingTopicTwo(Queue queueTopicTwo, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopicTwo).to(topicExchange).with("#.log");
    }

    @Bean
    public Binding bindingTopicThree(Queue queueTopicThree, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopicThree).to(topicExchange).with("good.#.timer");
    }
}
