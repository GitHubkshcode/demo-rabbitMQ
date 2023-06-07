package com.ksh.demorabbitMQ.working;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 三个队列同时监听
 * 消息是轮询分发的，一个消息只由一个消费者消费。
 */
@Component
public class WorkConsumer {
    @RabbitListener(queues = WorkingMqConfig.WORKING_QUEUE)
    public void processOne(String msg) {
        System.out.println("消费 WorkingMode1：" + msg);
    }

    @RabbitListener(queues = WorkingMqConfig.WORKING_QUEUE)
    public void processTwo(String msg) {
        System.out.println("消费 WorkingMode2：" + msg);
    }

    @RabbitListener(queues = WorkingMqConfig.WORKING_QUEUE)
    public void processThree(String msg) {
        System.out.println("消费 WorkingMode3：" + msg);
    }
}