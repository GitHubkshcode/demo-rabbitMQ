package com.ksh.demorabbitMQ.working;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkingMqConfig {

    public static final String WORKING_QUEUE = "WorkingMode";

    @Bean
    public Queue workingQueue() {
        return new Queue(WORKING_QUEUE, true);
    }
}
