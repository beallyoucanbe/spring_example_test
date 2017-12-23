package com.shuoyi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by zhaosy-c on 2017/12/23.
 */
@Configuration
@PropertySource("classpath:db.properties")
public class MyEnVironmentAware implements EnvironmentAware {

    @Value("${spring.datasource.url}")
    private String dataurl;

    @Override
    public void setEnvironment(Environment environment) {

        System.out.println("url = " + dataurl);
        System.out.println(environment.getClass());
        System.out.println(environment.getProperty("JAVA_HOME"));
        System.out.println(environment.getProperty("spring.datasource.username"));
        System.out.println(environment.getProperty("data.root.name"));
        RelaxedPropertyResolver relaxedPropertyResolver =
                new RelaxedPropertyResolver(environment, "spring.datasource.");
        System.out.println(relaxedPropertyResolver.getProperty("password"));
    }
}
