package org.example.constants;

public enum ExceptionEnum {
    USER_ALREADY_EXISTS(9001, "该用户已存在");

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
