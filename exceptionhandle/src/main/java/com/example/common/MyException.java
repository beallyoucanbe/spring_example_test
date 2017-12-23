package com.example.common;

/**
 * Created by zhaosy-c on 2017/12/23.
 */
public class MyException extends RuntimeException {

    private String code;

    public MyException(String code, String message){
        super(message);
        this.code = code;
    }

    public MyException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
