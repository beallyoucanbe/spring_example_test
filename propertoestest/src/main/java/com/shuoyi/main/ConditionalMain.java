package com.shuoyi.main;

import com.shuoyi.conditional.ListService;
import com.shuoyi.config.ConditionConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhaosy-c on 2017/12/23.
 */
public class ConditionalMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService listService = context.getBean(ListService.class);

        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的命令列表为：" + listService.showListCmd());

    }
}
