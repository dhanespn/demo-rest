package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePojo {
    private Integer statusCode;
    private Object message;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public ResponsePojo(Integer statusCode, Object message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponsePojo(Object message) {
        this.message = message;
    }
}