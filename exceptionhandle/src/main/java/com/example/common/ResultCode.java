package com.example.common;

/**
 * api返回各种code定义
 * Created by zhaosy-c on 2017/12/23.
 */
public enum ResultCode {

    SUCCESS("000", "success"),
    FAILED("111", "failed");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
