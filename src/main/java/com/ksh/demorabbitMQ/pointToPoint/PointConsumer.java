package com.ksh.demorabbitMQ.pointToPoint;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PointConsumer {

    /**
     * 监听的队列名
     * 根据队列名称消费指定队列中的消息
     */
    @RabbitListener(queues = PointToPointMqConfig.POINT_TO_POINT_QUEUE)
    public void processOne(String msg) {
        System.out.println("消费 point.to.point：" + msg);
    }
}