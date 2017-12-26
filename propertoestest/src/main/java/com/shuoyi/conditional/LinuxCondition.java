package com.shuoyi.conditional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by zhaosy-c on 2017/12/23.
 */
@ConfigurationProperties
public class LinuxCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(context.getClass());
        return context.getEnvironment().getProperty("os.name").contains("Linux");
    }
}
