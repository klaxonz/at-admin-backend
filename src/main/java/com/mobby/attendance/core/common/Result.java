package com.mobby.attendance.core.common;

import com.mobby.attendance.core.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author hulu
 * @ClassName Result.java
 * @Description
 * @createTime 2020年04月11日 12:31:00
 */
@Getter
@Setter
public class Result implements Serializable {

    private int code;
    private String message;
    private Object data;

    private Result(){}

    public Result(ResultCode resultCode){
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public Result(ResultCode resultCode, Object data){
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public static Result success(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result success(Object data){
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result failure(ResultCode resultCode){
        return new Result(resultCode);
    }

    public static Result failure(ResultCode resultCode, Object data){
        return new Result(resultCode, data);
    }

}
