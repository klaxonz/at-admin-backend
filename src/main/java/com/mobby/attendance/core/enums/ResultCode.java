package com.mobby.attendance.core.enums;

/**
 * @author hulu
 * @ClassName ResultCode.java
 * @Description
 * @createTime 2020年04月10日 20:27:00
 */
public enum ResultCode {

    SUCCESS(200, "成功"),
    JSON_PARSE_ERROR(1001, "返回json数据解析异常"),


    // 全局异常
    NULL_POINTER_EXCEPTION(2001, "空指针异常"),

    // 业务逻辑
    USERNAME_EXISTS(3001, "用户名已存在"),
    USERNAME_EMPTY(3002, "用户名为空"),
    PASSWORD_EMPTY(3003, "密码为空"),
    COLLEGE_NAME_EMPTY(3004, "学院名为空"),
    COLLEGE_EMPTY(3005, "学院为空"),

    // 数据库异常
    RECORD_INSERT(4001, "新增记录失败"),
    ACCOUNT_NOT_EXISTS(4002, "账户不存在"),
    ACCOUNT_OR_PASSWORD_ERROR(4003, "账号或密码错误")



            ;

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message(){
        return this.message;
    }

}
