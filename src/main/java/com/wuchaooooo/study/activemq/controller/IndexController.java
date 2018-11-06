package com.wuchaooooo.study.activemq.controller;

import com.wuchaooooo.study.activemq.producer.TestProducer;
import com.wuchaooooo.study.activemq.pojo.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;

@RestController
public class IndexController {

    @Autowired
    private TestProducer producer;

    @PostMapping(value = "/send", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void send(@RequestBody SendMessage sendMessage) throws JMSException {
        producer.send(sendMessage.getMessage());
    }
}
