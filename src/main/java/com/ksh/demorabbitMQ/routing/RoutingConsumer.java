package com.ksh.demorabbitMQ.routing;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RoutingConsumer {
    @RabbitListener(queues = RoutingMqConfig.QUEUE_ROUTING_ONE)
    public void processOne(String msg) {
        System.out.println("消费 " + RoutingMqConfig.QUEUE_ROUTING_ONE + "：" + msg);
    }

    @RabbitListener(queues = RoutingMqConfig.QUEUE_ROUTING_TWO)
    public void processTwo(String msg) {
        System.out.println("消费 " + RoutingMqConfig.QUEUE_ROUTING_TWO + "：" + msg);
    }

    @RabbitListener(queues = RoutingMqConfig.QUEUE_ROUTING_THREE)
    public void processThree(String msg) {
        System.out.println("消费 " + RoutingMqConfig.QUEUE_ROUTING_THREE + "：" + msg);
    }
}