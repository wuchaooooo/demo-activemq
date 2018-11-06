package com.wuchaooooo.study.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.transport.TransportListener;

import java.io.IOException;

public class ExtActiveMQConnectionFactory extends ActiveMQConnectionFactory {

    public ExtActiveMQConnectionFactory() {
        initActiveMQConnectionFactory();
    }

    private void initActiveMQConnectionFactory() {

        //配置信息可以从配置文件中读取

        //连接amq server 账号
        String username = "admin";
        //连接amq server 密码
        String password = "admin";
        //amq server 地址
        String brokerUrl = "failover:(tcp://127.0.0.1:61616)?initialReconnectDelay=100000";

        super.setUserName(userName);
        super.setPassword(password);
        super.setBrokerURL(brokerUrl);
        super.setTransportListener(new TransportListener() {
            public void onCommand(Object command) {
                System.out.println(command);
            }

            public void onException(IOException error) {
                System.out.println(error);
            }

            public void transportInterupted() {
                System.out.println("down");
            }

            public void transportResumed() {
                System.out.println("up");
            }
        });
    }


}
