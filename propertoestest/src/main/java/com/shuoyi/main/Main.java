package com.shuoyi.main;

import com.shuoyi.config.ELConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.TreeMap;

/**
 * Created by zhaosy-c on 2017/12/20.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        System.out.println(context.getEnvironment().getClass());
        ELConfig resourceService = context.getBean(ELConfig.class);
        resourceService.outputResource();
//
//        PropertyService propertyService = context.getBean(PropertyService.class);
//
//        propertyService.readValues();

        context.close();
    }
}
