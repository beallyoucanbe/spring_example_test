package com.shuoyi.config;

import com.shuoyi.model.ConnectionSettings;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhaosy-c on 2017/12/26.
 */
@Configuration
@EnableConfigurationProperties(ConnectionSettings.class)
public class ConfigurationPropertiesConfig {
}
