package com.threeeggpie.template.pojo;

import com.threeeggpie.template.enmu.ErrorEnum;
import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    private static Result<Object> result = new Result<>();

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T data) {
        this.code = 200;
        this.data = data;
    }

    public Result(ErrorEnum errorEnum) {
        code = errorEnum.getCode();
        msg = errorEnum.getMsg();
    }

    public Result() {
        code = 200;
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> error(ErrorEnum errorEnum) {
        return new Result<T>(errorEnum);
    }


    /**
     * 静态空result，避免频繁new对象
     * @return result
     */
    public static Result<Object> emptyResult() {
        return Result.result;
    }
}