package com.example.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhaosy-c on 2017/12/23.
 */
@Getter
@Setter
public class RestResult<T> {

    private String code = ResultCode.SUCCESS.getCode();
    private String message = ResultCode.SUCCESS.getMessage();
    private T data;

    public RestResult(){

    }

    public RestResult(T data) {
        this.data = data;
    }

    public RestResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
