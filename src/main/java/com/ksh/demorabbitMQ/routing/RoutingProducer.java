package com.ksh.demorabbitMQ.routing;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class RoutingProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 将消息发送到指定的交换机
     */
    public void send(String routingKey) {
        String sendMsg = "路由模式:" + routingKey + "   " + new Date();
        rabbitTemplate.convertAndSend(RoutingMqConfig.ROUTING_EXCHANGE, routingKey, sendMsg);
    }
}