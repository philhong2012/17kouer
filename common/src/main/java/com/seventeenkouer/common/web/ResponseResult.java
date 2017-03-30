package com.seventeenkouer.common.web;

/**
 * com.zdnst.common.infra.web.ResponseResult.java
 * Created by zhoujun on 16/3/8.
 */
public class ResponseResult<T> {

    private String message;
    private String code;// 默认 0失败,1成功
    private long timestamp = System.currentTimeMillis();
    private T data;
    private String sid;
    private String detailMessage;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }
}
