package com.guanyu.app.model.miniapp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * 信息实体
 * @author Guanyu
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@TableName(value = "mini_message")
public class MessageDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 父级评论id
     */
    private Long parentId;

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
     * 消息状态 0-不可见，1-可见
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    public static MessageDO init(long userId, long parentId, String comment) {
        MessageDO message = new MessageDO();
        message.setUserId(userId);
        message.setParentId(parentId);
        message.setComment(comment);
        message.setCreateTime(new Date());
        message.setLikeNum(0);
        message.setTopFlag(0);
        message.setStatus(1);
        return message;
    }
}
