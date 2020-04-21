package com.mobby.attendance.core.handler;

import com.mobby.attendance.core.common.Result;
import com.mobby.attendance.core.enums.ResultCode;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hulu
 * @ClassName GlobalExceptionHandler.java
 * @Description 全局异常处理
 * @createTime 2020年04月11日 14:28:00
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value =NullPointerException.class)
    public Result exceptionHandler(HttpServletRequest req, NullPointerException e){
        return Result.failure(ResultCode.NULL_POINTER_EXCEPTION, e.getMessage());
    }


}
