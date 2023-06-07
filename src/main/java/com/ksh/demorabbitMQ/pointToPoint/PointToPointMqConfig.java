package com.ksh.demorabbitMQ.pointToPoint;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PointToPointMqConfig {

    public static final String POINT_TO_POINT_QUEUE = "point.to.point";

    /**
     * 创建队列，指定队列名称
     */
    @Bean
    public Queue pointToPointQueue() {
        return new Queue(POINT_TO_POINT_QUEUE, false);
    }
}
