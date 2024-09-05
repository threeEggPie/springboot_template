package com.threeeggpie.template.exception;

import com.threeeggpie.template.enmu.ErrorEnum;

public class BaseException extends RuntimeException {
    private ErrorEnum errorEnum;
    private String message;

    public BaseException(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum == null ? ErrorEnum.ERROR : errorEnum;
    }

    @Override
    public String getMessage() {
        return message;
    }
}