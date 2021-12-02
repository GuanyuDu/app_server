package com.guanyu.app.util.net;

import com.guanyu.app.constant.ErrorCode;

/**
 * HTTP 请求返回值
 *
 * @author Guanyu
 */
public class HttpResponse<T> {

    private final int code;

    private final String message;

    private T data;


    public HttpResponse(ErrorCode errorCode) {
        this.code = errorCode.code;
        this.message = errorCode.msg;
    }

    public HttpResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> HttpResponse<T> fail(ErrorCode errorCode) {
        return new HttpResponse<>(errorCode.code, errorCode.msg);
    }

    public static <T> HttpResponse<T> of(int code, String message, T data) {
        return new HttpResponse<>(code, message, data);
    }

    public T dataOrNull() {
        return this.data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
