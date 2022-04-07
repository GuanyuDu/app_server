package com.guanyu.app.model.dto;

import com.guanyu.app.model.miniapp.MessageDO;
import com.guanyu.app.model.miniapp.UserDO;
import com.guanyu.app.util.TimeFormatHelper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;

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
    private String createTime;


    public static MessageDTO init(MessageDO messageDO, UserDO user) {
        MessageDTO message = new MessageDTO();
        message.setNickname(user.getNickname());
        message.setAvatar(user.getAvatar());
        message.setComment(messageDO.getComment());
        message.setTopFlag(messageDO.getTopFlag());
        message.setLikeNum(messageDO.getLikeNum());
        message.setCreateTime(TimeFormatHelper.STANDARD.format(LocalDateTime
                .ofInstant(messageDO.getCreateTime().toInstant(), ZoneId.systemDefault())));
        return message;
    }
}
