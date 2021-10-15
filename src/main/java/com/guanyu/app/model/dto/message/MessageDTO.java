package com.guanyu.app.model.dto.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 消息传输对象
 *
 * @author Guanyu
 */
@Getter
@Setter
@ToString
public class MessageDTO {

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像 URL
     */
    private String avatar;

    /**
     * 评论
     */
    private String comment;

    /**
     * 是否置顶: 1: 置顶, 0: 未置顶
     */
    private Integer topFlag;

    /**
     * 点赞数
     */
    private Integer likeNum;


    /**
     * 创建时间
     */
    private Date createTime;
}
