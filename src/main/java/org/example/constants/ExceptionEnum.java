package org.example.constants;

public enum ExceptionEnum {
    USER_ALREADY_EXISTS(9001, "该用户已存在"),
    VIOLATION_EXP(9002, "参数校验异常"),
    USER_NOT_EXIST(9003, "该用户不存在"),
    WRONG_PASSWORD(9004, "密码错误")
;
    private final int code;
    private final String name;

    ExceptionEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
