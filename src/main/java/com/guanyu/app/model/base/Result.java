package com.guanyu.app.model.base;

import com.guanyu.app.constant.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author guanyu
 */
@Getter
@Setter
public class Result<T> {

    public static final int SUC_CODE = 0;

    public static final String SUC_MSG = "success";

    protected int code;

    protected String message;

    protected T data;

    protected Result(int code) {
        this.code = code;
    }

    protected Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    protected Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> ok() {
        return new Result<>(SUC_CODE, SUC_MSG);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(SUC_CODE, SUC_MSG, data);
    }

    public static <T> Result<T> fail(ErrorCode errorCode) {
        return new Result<>(errorCode.code, errorCode.msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, msg);
    }

    public static <T> Result<T> fail(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

}
