package com.ksh.demorabbitMQ.working;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class WorkProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        String sendMsg = "工作模式:" + msg + "   " + new Date();
        //指定队列
        this.rabbitTemplate.convertAndSend(WorkingMqConfig.WORKING_QUEUE, sendMsg);
    }
}