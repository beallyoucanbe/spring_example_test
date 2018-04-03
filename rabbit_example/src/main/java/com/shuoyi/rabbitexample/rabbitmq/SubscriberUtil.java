package com.shuoyi.rabbitexample.rabbitmq;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhaosy-c on 2018/2/10.
 */
@Component
public class SubscriberUtil {

    private static Logger logger = Logger.getLogger(SubscriberUtil.class);

    @Autowired
    @Qualifier("receiveRabbitTemplate")
    RabbitTemplate receiveRabbitTemplate;

    public void addQueueListener(MessageHandle handle){
        Runnable oRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        Message oMessage = receiveRabbitTemplate.receive();
                        if(null == oMessage){
                            Thread.sleep(5000);
                        } else {
                            String sMessage;
                            try {
                                sMessage = new String(oMessage.getBody(), "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                logger.error("message cannot convet [utf-8]", e);
                                sMessage = new String(oMessage.getBody());
                            }
                            handle.process(sMessage);
                        }
                    }
                }catch (Exception e){
                   logger.error("发生异常，监听线程将于1分钟后重启", e);
                    try {
                        Thread.sleep(1000*60);
                        addQueueListener(handle);
                    } catch (InterruptedException e1) {
                        logger.error("监听线程重启失败");
                    }
                }
            }
        };
        new Thread(oRunnable).start();
    }
}
