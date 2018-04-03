package com.shuoyi.rabbitexample.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by zhaosy-c on 2018/2/3.
 */
@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.host}")
    private String host;

    @Value("${rabbitmq.port}")
    private String port;

    @Value("${rabbitmq.username}")
    private String username;

    @Value("${rabbitmq.password}")
    private String password;

    /****************************** Receive配置 ****************************************/

    @Value("${rabbitmq.receiveNotify.virtualHost}")
    private String receiveVirtualHost;

    @Value("${rabbitmq.receiveNotify.exchangeName}")
    private String receiveExchangeName;

    @Value("${rabbitmq.receiveNotify.queueName}")
    private String receiveQueueName;
    /****************************** Send配置 ****************************************/

    @Value("${rabbitmq.sendNotify.virtualHost}")
    private String sendVirtualHost;

    @Value("${rabbitmq.sendNotify.exchangeName}")
    private String sendExchangeName;

    @Value("${rabbitmq.sendNotify.queueName}")
    private String sendQueueName;

    /**************************** Receive Bean ********************************************/

    @Bean(name = "receiveConnectionFactory")
    @Primary
    public ConnectionFactory createReceiveConnectionFactory() {
        return createConnectionFactory(receiveVirtualHost);
    }

    @Bean(name = "receiveRabbitTemplate")
    @Primary
    public RabbitTemplate createReceiveRabbitTemplate(@Qualifier("receiveConnectionFactory") ConnectionFactory
                                                              connectionFactory, @Qualifier
                                                              ("jsonMessageConverter") Jackson2JsonMessageConverter messageConverter) {
        return createRabbitTemplate(connectionFactory, messageConverter, receiveExchangeName, receiveQueueName, false);
    }

    /**************************** Send Bean ********************************************/

    @Bean(name = "sendConnectionFactory")
    public ConnectionFactory createSendConnectionFactory() {
        return createConnectionFactory(sendVirtualHost);
    }

    @Bean(name = "sendRabbitTemplate")
    public RabbitTemplate createSendRabbitTemplate(@Qualifier("sendConnectionFactory") ConnectionFactory
                                                           connectionFactory, @Qualifier
                                                           ("jsonMessageConverter") Jackson2JsonMessageConverter messageConverter) {
        return createRabbitTemplate(connectionFactory, messageConverter, sendExchangeName, sendQueueName, false);
    }

    /**************************** 公共Bean **********************************************/
    @Bean(name = "jsonMessageConverter")
    public Jackson2JsonMessageConverter createJsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**************************** 创建Bean的公共方法 **************************************/

    private ConnectionFactory createConnectionFactory(String virtualHost) {
        CachingConnectionFactory oConnectionfactory = new CachingConnectionFactory(host, Integer.valueOf(port));
        oConnectionfactory.setUsername(username);
        oConnectionfactory.setPassword(password);
        oConnectionfactory.setVirtualHost(virtualHost);
        return oConnectionfactory;
    }

    private RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter
            messageConverter, String exchangeName, String queueName, boolean channelTransacted) {
        RabbitTemplate oRabbitTemplate = new RabbitTemplate(connectionFactory);
        oRabbitTemplate.setExchange(exchangeName);
        oRabbitTemplate.setQueue(queueName);
        oRabbitTemplate.setChannelTransacted(channelTransacted); // 非事务性,参考gbq
        oRabbitTemplate.setMessageConverter(messageConverter);
        return oRabbitTemplate;
    }
}
