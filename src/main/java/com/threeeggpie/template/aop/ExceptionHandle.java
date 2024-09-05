package com.threeeggpie.template.aop;


import com.threeeggpie.template.enmu.ErrorEnum;
import com.threeeggpie.template.exception.BaseException;
import com.threeeggpie.template.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public Result<String> exceptionGet(BaseException e) {
        e.printStackTrace();
        return Result.error(e.getErrorEnum());
    }
    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public Result<ErrorEnum> exceptionGet(SQLException e) {
        log.error("【数据库异常】");
        e.printStackTrace();
        return Result.error(ErrorEnum.DATA_ERROR);
    }



    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<ErrorEnum> exceptionGet(Exception e) {
        log.error("【系统异常】{}", e.getMessage());
        e.printStackTrace();
        return Result.error(ErrorEnum.ERROR);
    }
}