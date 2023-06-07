package com.ksh.demorabbitMQ.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
    @RabbitListener(queues = TopicMqConfig.QUEUE_TOPIC_ONE)
    public void processOne(String msg) {
        System.out.println("消费 " + TopicMqConfig.QUEUE_TOPIC_ONE + "：" + msg);
    }

    @RabbitListener(queues = TopicMqConfig.QUEUE_TOPIC_TWO)
    public void processTwo(String msg) {
        System.out.println("消费 " + TopicMqConfig.QUEUE_TOPIC_TWO + "：" + msg);
    }

    @RabbitListener(queues = TopicMqConfig.QUEUE_TOPIC_THREE)
    public void processThree(String msg) {
        System.out.println("消费 " + TopicMqConfig.QUEUE_TOPIC_THREE + "：" + msg);
    }
}