package com.ksh.demorabbitMQ.controller;

import com.ksh.demoes.common.AjaxResult;
import com.ksh.demorabbitMQ.pointToPoint.PointProducer;
import com.ksh.demorabbitMQ.publishSubscribe.PublishProducer;
import com.ksh.demorabbitMQ.routing.RoutingProducer;
import com.ksh.demorabbitMQ.topic.TopicProducer;
import com.ksh.demorabbitMQ.working.WorkProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("message")
public class MessageController {
    @Resource
    private PointProducer pointProducer;
    @Resource
    private WorkProducer workProducer;
    @Resource
    private PublishProducer publishProducer;
    @Resource
    private RoutingProducer routingProducer;
    @Resource
    private TopicProducer topicProducer;

    @PostMapping("send")
    public AjaxResult send(String msg) {
//        pointProducer.send(msg);
//        workProducer.send(msg);
        publishProducer.send(msg);
        return AjaxResult.success("发送成功");
    }

    @PostMapping("send/{routingKey}")
    public AjaxResult sendByRoutingKey(@PathVariable("routingKey") String routingKey) {
        routingProducer.send(routingKey);
        return AjaxResult.success("发送成功");
    }

    @RequestMapping("/send/topic/{type}")
    public AjaxResult sendByTopic(@PathVariable String type) {
        topicProducer.send(type);
        return AjaxResult.success("发送成功");
    }
}
