package com.innovation.demoservlet.Dto;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-07-16 10:43 PM Saturday
 **/
public class APIResponse {
    private Object result;
    private String message;
    private Object meta;

    public APIResponse() {
    }
    public APIResponse(Object result, String message, Object meta) {
        this.result = result;
        this.message = message;
        this.meta = meta;
    }

    public APIResponse(Object result, String message) {
        this.result = result;
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }
}
