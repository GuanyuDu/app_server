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
    PATH_NOT_FOUND(404,"路径未找到"),
    PARAM_TYPE_ERROR(400,"参数类型错误"),
    UNKNOWN_ERROR(500,"服务器开小差了"),
    INVALID_REQUEST(401, "key验证未通过");


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
