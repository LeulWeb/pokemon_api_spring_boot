package com.pockemon.api.exceptions;

import lombok.Data;

import java.util.Date;


public class ErrorResponseObject {
    private  Integer statusCode;
    private  String message;
    private Date timestamp;

    public ErrorResponseObject() {
    }

    public ErrorResponseObject(Integer statusCode, String message, Date timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
