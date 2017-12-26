package com.shuoyi.control;

import com.shuoyi.model.ConnectionSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaosy-c on 2017/12/26.
 */
@RestController
@RequestMapping("/api/common")
public class Test {

    @Autowired
    ConnectionSettings connectionSettings;

    @GetMapping("/test")
    public String test(){

        System.out.println(connectionSettings.getUsername());
        return "hello";
    }
}
