package com.youkeda.application.ebusiness.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author 刘铭垚
 * @version 1.0
 * json返回模型
 */
public class Result<D> implements Serializable {

    //表示执行成功或者失败
    @JsonProperty("isSuccess")
    private boolean success = false;

    //返回消息短码
    private String code;

    //返回消息信息
    private String message;

    //返回的具体数据
    private D data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
