package com.shuoyi.rabbitexample.rabbitmq;

/**
 * Created by zhaosy-c on 2018/2/10.
 */
public interface MessageHandle {

    void process(String sMessage);
}
