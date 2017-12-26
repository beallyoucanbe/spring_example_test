package com.shuoyi.main;

import com.shuoyi.config.ConfigurationPropertiesConfig;
import com.shuoyi.model.ConnectionSettings;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhaosy-c on 2017/12/26.
 */
public class ConfigurationPropertiesMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigurationPropertiesConfig.class);

        ConnectionSettings connectionSettings = context.getBean(ConnectionSettings.class);

        System.out.println(connectionSettings.getPassword());
        System.out.println(connectionSettings.getUsername());
    }
}
