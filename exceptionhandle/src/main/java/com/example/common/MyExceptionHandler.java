package com.example.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaosy-c on 2017/12/23.
 */
@ControllerAdvice(basePackages = "com.example.controller")
public class MyExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public RestResult exceptionHandle(Exception e){
        if(e instanceof MyException)
            return new RestResult<Void>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage());
        else{
            return new RestResult(e.getClass().toString());
        }
    }
}
