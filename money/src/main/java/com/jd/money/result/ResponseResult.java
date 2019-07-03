package com.jd.money.result;

import com.jd.money.pojo.Money;

import java.util.List;

public class ResponseResult {

    private Integer code;

    private String msg;

    private String data;

    public ResponseResult() {
    }

    public ResponseResult(String msg, String data) {
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
