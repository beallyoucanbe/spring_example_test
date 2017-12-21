package com.shuoyi.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by zhaosy-c on 2017/12/20.
 */
@Configuration
@ComponentScan("com.shuoyi.service")
@PropertySources({
    @PropertySource("classpath:Mongodb.properties"),
    @PropertySource("classpath:application.properties")
})
public class ELConfig {

    @Value("I love you")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    @Value("#{demoService.another}")
    private String fromAnother;

    @Value("classpath:test.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;

    @Value("${Mongodb.serverAddr}")
    private String mongoaddress;

    @Autowired
    private Environment environment;

    public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
//            System.out.println(normal);
//            System.out.println(osName);
//            System.out.println(randomNumber);
//            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
//            System.out.println(IOUtils.toString(testUrl.getInputStream()));
//            System.out.println(mongoaddress);
            System.out.println(environment.getActiveProfiles());

            System.out.println(environment.getClass());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
