package com.seventeenkouer.web;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/25
 * Time: 下午11:40
 * To change this template use File | Settings | File Templates.
 */
public class ResponseResult {
    private String code;
    private Object message;

    public ResponseResult(String resultCode,Object o) {
        this.code = resultCode;
        this.message = o;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
