package com.guanyu.app.constant;

import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;

/**
 * @author Guanyu
 */
public enum ErrorCode {

    /**
     * 对外状态码
     */
    SUCCESS(0,"服务酱受理了你的请求"),
    PATH_NOT_FOUND(404,"服务酱迷路了"),
    PARAM_TYPE_ERROR(400,"检查一下你的请求参数吧"),
    INVALID_REQUEST(401, "服务酱好像不认识你哦"),
    UNKNOWN_ERROR(500,"哎呀！服务酱没有理你，并向你丢了一只 Bug"),
    DEPENDENT_SERVICE_ERROR(1501, "依赖服务未能返回结果"),

    /**
     * 业务错误码
     */
    SHARE_LINK_FORMAT_ERROR(2001, "分享链接格式错误"),
    COMMENTS_NOT_AVAILABLE(2002, "评论暂时不可用"),

    /**
     * 服务内部状态码
     */
    HTTP_REQUEST_FAILED(1502, "发送 HTTP 请求失败"),
    DEPENDENT_SERVICE_TIMEOUT(1408, "依赖服务超时");


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
