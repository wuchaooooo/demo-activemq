package com.wuchaooooo.study.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        startConsumer();
    }

    private void startConsumer() {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        ThreadPoolTaskExecutor threadPoolTaskExecutor = (ThreadPoolTaskExecutor) applicationContext.getBean("threadPool");
        TestConsumer testConsumer = (TestConsumer) applicationContext.getBean("testConsumer");
        threadPoolTaskExecutor.execute(testConsumer);
        TestProducer testProducer = (TestProducer) applicationContext.getBean("testProducer");
        for (int i = 0; i < 100; i++) {
            try {
                testProducer.send();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
