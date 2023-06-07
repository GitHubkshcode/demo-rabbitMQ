package com.ksh.demorabbitMQ.publishSubscribe;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class PublishProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 将消息发送到指定的交换机
     */
    public void send(String msg) {
        String sendMsg = "发布订阅模式:" + msg + "   " + new Date();
        this.rabbitTemplate.convertAndSend(PublishMqConfig.PUBLISH_EXCHANGE, "", sendMsg);
    }
}