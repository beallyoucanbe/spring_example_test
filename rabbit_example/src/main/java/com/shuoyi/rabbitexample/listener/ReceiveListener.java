package com.shuoyi.rabbitexample.listener;

import com.shuoyi.rabbitexample.rabbitmq.MessageHandle;
import com.shuoyi.rabbitexample.rabbitmq.SubscriberUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by zhaosy-c on 2018/2/10.
 */
public class ReceiveListener implements ApplicationListener<ContextRefreshedEvent> {


    Logger logger = Logger.getLogger(ReceiveListener.class);

    @Autowired
    SubscriberUtil subscriberUtil;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        subscriberUtil.addQueueListener(new MessageHandle() {
            @Override
            public void process(String sMessage) {
                System.out.println(sMessage);
            }
        });
    }
}
