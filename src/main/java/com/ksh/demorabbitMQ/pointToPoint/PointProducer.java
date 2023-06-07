package com.ksh.demorabbitMQ.pointToPoint;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class PointProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 想指定队列发送消息
     */
    public void send(String msg) {
        String sendMsg = "点对点队列:" + msg + "   " + new Date();
        //指定队列
        this.rabbitTemplate.convertAndSend(PointToPointMqConfig.POINT_TO_POINT_QUEUE, sendMsg);
    }
}