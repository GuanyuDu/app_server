package com.guanyu.app.constant;

/**
 * 小程序 UI 组件名枚举
 *
 * @author Guanyu
 */
public enum MiniAppUIEnum {

    COMMENT_BUTTON("comment_button", "评论按钮"),

    /**
     * 功能列表
     */
    FUNC_VIDEO_DOWNLOAD("func_video_download", "分享链接视频下载"),
    FUNC_DAILY_FOOD("func_daily_food", "今天吃什么")
    ;

    private final String code;

    private final String name;


    MiniAppUIEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
