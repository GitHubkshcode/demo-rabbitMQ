package com.ksh.demorabbitMQ.publishSubscribe;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PublishConsumer {
    /**
     * 监听的队列名
     * 根据队列名称消费指定队列中的消息
     */
    @RabbitListener(queues = PublishMqConfig.QUEUE_PUBLISH_ONE)
    public void processOne(String msg) {
        System.out.println("消费 " + PublishMqConfig.QUEUE_PUBLISH_ONE + "：" + msg);
    }

    @RabbitListener(queues = PublishMqConfig.QUEUE_PUBLISH_TWO)
    public void processTwo(String msg) {
        System.out.println("消费 " + PublishMqConfig.QUEUE_PUBLISH_TWO + "：" + msg);
    }

    @RabbitListener(queues = PublishMqConfig.QUEUE_PUBLISH_THREE)
    public void processThree(String msg) {
        System.out.println("消费 " + PublishMqConfig.QUEUE_PUBLISH_THREE + "：" + msg);
    }
}