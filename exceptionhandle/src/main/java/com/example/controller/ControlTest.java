package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.common.MyException;
import com.example.common.RestResult;
import com.example.common.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaosy-c on 2017/12/23.
 */
@RestController
@RequestMapping("/api/common")
public class ControlTest {

    @GetMapping("/test")
    public RestResult test(){
        RestResult oRestResult = new RestResult();
        JSONObject object = new JSONObject();
        object.put("name", "tony");
        oRestResult.setData(object);
        return oRestResult;
    }

    @GetMapping("/test_exception")
    public RestResult testException(){
        System.out.println("thios is the exception test");
        throw new MyException(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage());
    }
}
