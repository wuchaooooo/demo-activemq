package com.wuchaooooo.study.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class TestProducer {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private Queue testQueue;

    public void send(String message) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageProducer producer = session.createProducer(testQueue);
        TextMessage textMessage = session.createTextMessage(message);
        producer.send(textMessage);
        System.out.println("消息发送成功");
    }
}
