package com.guanyu.app.constant;

import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;

/**
 * @author v.duguanyu
 */
public enum ErrorCode {

    /**
     * 请求成功
     */
    SUCCESS(0,"服务酱受理了你的请求"),
    PATH_NOT_FOUND(404,"服务酱迷路了"),
    PARAM_TYPE_ERROR(400,"检查一下你的请求参数吧"),
    INVALID_REQUEST(401, "服务酱好像不认识你哦"),
    UNKNOWN_ERROR(500,"哎呀！服务酱没有理你，并向你丢了一只 Bug");

    public final int code;
    public final String msg;
    public final byte[] jsonBytesRet;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.jsonBytesRet = toJson().getBytes(StandardCharsets.UTF_8);
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returnCode", this.code);
        jsonObject.put("returnMsg", this.msg);
        return jsonObject.toString();
    }
}
