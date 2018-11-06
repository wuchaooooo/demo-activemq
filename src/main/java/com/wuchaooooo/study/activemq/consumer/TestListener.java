package com.wuchaooooo.study.activemq.consumer;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class TestListener implements MessageListener {
    public void onMessage(Message message) {

        new Thread(() -> {
            System.out.println("s");
        });
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println(msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
