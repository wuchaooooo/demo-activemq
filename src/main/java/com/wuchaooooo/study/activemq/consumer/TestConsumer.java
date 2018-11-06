package com.wuchaooooo.study.activemq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class TestConsumer implements Runnable{

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private MessageListener messageListener;

    @Autowired
    private Queue testQueue;

    public void run() {
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(testQueue);
            consumer.setMessageListener(messageListener);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
