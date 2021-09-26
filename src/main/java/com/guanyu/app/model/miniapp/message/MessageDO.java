package com.guanyu.app.model.miniapp.message;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 信息实体
 * @author Guanyu
 */
@Getter
@Setter
@ToString
@TableName(value = "message")
public class MessageDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 父级评论id
     */
    private Long parentId;

    /**
     * 微信用户 OpenID
     */
    private String openId;

    /**
     * 评论
     */
    private String comments;

    /**
     * 是否置顶: 1: 置顶, 0: 未置顶
     */
    private Integer top;

    /**
     * 点赞数
     */
    private Integer isLike;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
