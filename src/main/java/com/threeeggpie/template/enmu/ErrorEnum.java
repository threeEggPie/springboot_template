package com.threeeggpie.template.enmu;

import lombok.Getter;

@Getter
public enum ErrorEnum {

    /**
     * 其他
     */
    ERROR_LOGIN(400, "账号或密码不正确"),
    UN_LOGIN(401, "尚未登陆"),
    NO_AUTH(402, "没有权限执行此操作"),
    ERROR_PARAMETER(403, "参数异常"),
    ERROR_FILE(405, "文件上传异常"),
    OPERATION_FORBIDDEN(406, "操作禁止"),
    OPERATION_TIME_FORBIDDEN(407, "操作未开放"),
    DATA_REPLICATION(408, "数据重复"),

    /**
     * 编码可能导致的问题
     */

    ERROR(500, "系统内部异常"),
    DATA_ERROR(501, "数据库数据异常");

    private Integer code;

    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}