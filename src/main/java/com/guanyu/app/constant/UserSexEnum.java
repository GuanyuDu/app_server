package com.guanyu.app.constant;

/**
 * 用户性别枚举值
 *
 * @author Guanyu
 */
public enum UserSexEnum {

    WOMEN(0, "女"),
    MAN(1, "男"),
    OTHER(2, "未知")
    ;

    private final int code;

    private final String name;

    UserSexEnum(int code, String name) {
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
