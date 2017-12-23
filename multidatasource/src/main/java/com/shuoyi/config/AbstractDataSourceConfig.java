package com.shuoyi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by zhaosy-c on 2017/12/23.
 */
public class AbstractDataSourceConfig {

    public DataSource getDataSource(RelaxedPropertyResolver propertyResolver) throws SQLException {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("url"));
        datasource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        datasource.setUsername(propertyResolver.getProperty("username"));
        datasource.setPassword(propertyResolver.getProperty("password"));
        datasource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("druid.initial-size")));
        datasource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("druid.min-idle")));
        datasource.setMaxWait(Long.valueOf(propertyResolver.getProperty("druid.max-wait")));
        datasource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("druid.max-active")));
        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("druid.min-evictable-idle-time-millis")));
        datasource.setFilters("stat,wall,log4j");
        return datasource;
    }
}
