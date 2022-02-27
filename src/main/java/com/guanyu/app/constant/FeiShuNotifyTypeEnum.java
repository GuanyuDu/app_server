package com.guanyu.app.constant;


/**
 * 飞书通知消息类型
 *
 * @author Guanyu
 */
public enum FeiShuNotifyTypeEnum {

    /**
     * 文本
     */
    TEXT("text"),

    /**
     * 富文本
     */
    POST("post"),

    /**
     * 图片
     */
    IMAGE("image"),

    /**
     * 分享群名片
     */
    SHARE_CHAT("share_chat"),

    /**
     * 消息卡片
     */
    INTERACTIVE("interactive");

    public String value;

    FeiShuNotifyTypeEnum(String value) {
        this.value = value;
    }
}
