package com.ksh.demorabbitMQ.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class TopicProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(String routing) {
        String sendMsg = "主题模式:" + routing + "   " + new Date();
        //指定队列
        this.rabbitTemplate.convertAndSend(TopicMqConfig.TOPIC_EXCHANGE, routing, sendMsg);
    }
}